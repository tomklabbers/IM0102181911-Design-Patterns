package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
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
	private static final int itemSpacing = 4;
	private Frame parentView;
	private Slide model;
	private Map<Rectangle, SlideItem> itemLookup;
	public SlideView() {
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(getParent().getWidth(), getParent().getHeight());
	}
	
	public void setSlide(Slide slide) {
		model = slide;
		
		repaint();
	}
	
	public SlideItem getItemAtPos(int x, int y) {
		for (Map.Entry<Rectangle, SlideItem> item : itemLookup.entrySet()) {
			if (item.getKey().contains(x, y)) {
				return item.getValue();
			}
		}
		return null;
	}
	
	public void drawSlide(Slide slide, PainterFactory factory) {
		int y = itemSpacing;
		itemLookup = new HashMap<Rectangle, SlideItem>();
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
			int x = item.getStyle().getIndent();
			Rectangle location = null;
			BorderStyle borderStyle = null;
			if (item.getStyle() instanceof BorderStyle) {
				borderStyle = (BorderStyle)item.getStyle();
				int strokeWidth = factory.getScaled(borderStyle.getBorderStrokeWidth());
				location = new Rectangle(x + strokeWidth, y + strokeWidth, PresentationView.WIDTH - x - strokeWidth , 0);
			}
			else {
				location = new Rectangle(x, y, PresentationView.WIDTH - x, 0);
			}
			Rectangle result = painter.draw(item, location);
			
			if(borderStyle != null) {			
				SlidePainter borderpainter = factory.createBorderPainter();		
				int strokeWidth = factory.getScaled(borderStyle.getBorderStrokeWidth());				
				Rectangle borderLocation = new Rectangle(x,y, result.width + strokeWidth *2 , result.height + strokeWidth * 2);
				result = borderpainter.draw(item, borderLocation);
			}
			if (result != null) {
				y += result.height + factory.getScaled(itemSpacing);
			}						
		}
	}	
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);		
		g.fillRect(0,0, getSize().width, getSize().height);		
		if(model != null) {
			System.out.println("Painting");
			PainterFactory factory = AbstractPainterFactory.GraphicsPainter(g, new Rectangle(getParent().getWidth(), getParent().getHeight()), this);  			
			drawSlide(model, factory);
		}
//		
//		
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
