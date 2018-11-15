package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JComponent;

import interfaces.Slide;
import model.SlideItem;
import painter.AbstractPainterFactory;
import painter.PainterFactory;
import painter.SlidePainter;
import styles.BorderStyle;

public class SlideView extends JComponent {
	
	private static final long serialVersionUID = 1L;
	
	private Frame parentView;
	private Slide model;
	public SlideView(Frame parent) {
		parentView = parent;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(parentView.getWidth(), parentView.getHeight());
	}
	
	public void setSlide(Slide slide) {
		model = slide;
		
		repaint();
	}
	
	public void drawSlide(Slide slide, PainterFactory factory) {
		int y = 0;
		System.out.println(slide);
		for (SlideItem item : slide.getItems()) {
			SlidePainter painter = null;
			switch (item.getType()) {
				case "text":{
					painter = factory.createTextPainter();
					break;
				}
				case "image":{
					painter = factory.createImagePainter();
					break;
				}
			}	
			if (painter == null) {
				continue;
			}
			int x = item.getLevel() * 20;
			Rectangle location = new Rectangle(x, y, PresentationView.WIDTH - x, 0); 
			BorderStyle borderStyle = null;
			if (item.getStyle() instanceof BorderStyle) {
				borderStyle = (BorderStyle)item.getStyle();
				location.x += borderStyle.getBorderStrokeWidth();
				location.width = location.width - (borderStyle.getBorderStrokeWidth() * 2);				
			}
			Rectangle result = painter.draw(item, location);
			if(borderStyle != null) {
				SlidePainter borderpainter = factory.createBorderPainter();				
				Rectangle borderLocation = new Rectangle(x,y, PresentationView.WIDTH - x, result.height + borderStyle.getBorderStrokeWidth());
				result = borderpainter.draw(item, borderLocation);
			}
			if (result != null) {
				y += result.height;
			}						
		}
	}	
	
	public void paintComponent(Graphics g) {
		if(model != null) {
			System.out.println("Painting");
			PainterFactory factory = AbstractPainterFactory.GraphicsPainter(g, new Rectangle(parentView.getWidth(), parentView.getHeight()), this);  
			
			drawSlide(model, factory);
		}
//		g.setColor(Color.BLUE);
//		g.fillRect(getSize().width/4, getSize().height/4, getSize().width/2, getSize().height/2);
//		if (presentation.getSlideNumber() < 0 || slide == null) {
//			return;
//		}
//		g.setFont(labelFont);
//		g.setColor(COLOR);
//		g.drawString("Slide " + (1 + presentation.getSlideNumber()) + " of " +
//                 presentation.getSize(), XPOS, YPOS);
//		Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
//		slide.draw(g, area, this);
	}
}
