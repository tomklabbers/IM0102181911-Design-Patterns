package view;

import java.awt.Dimension;
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
	private static final int yMargin 	= 20;
	private static final int xMargin 	= 20;
	
	private Slide model;
	private Map<Rectangle, SlideItem> itemLookup;
	private PresentationView parentView;
	public SlideView(PresentationView view) {
		this.parentView = view;
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
	
	private int getDrawWidth() {
		// xMargin is applied two times, left and right
		return getSize().width - (xMargin * 2);
	}
	
	public void drawSlide(Slide slide, PainterFactory factory) {
		int y = itemSpacing;
		itemLookup = new HashMap<Rectangle, SlideItem>();
		for (SlideItem item : slide.getItems()) {
			SlidePainter painter = null;
			switch (item.getType()) {
				case "menu":
				case "text":
					painter = factory.createTextPainter();
					break;
				
				case "image":
					painter = factory.createImagePainter();
					break;
			}	
			if (painter == null) {
				continue;
			}
			int x = painter.scale(item.getStyle().getIndent());
			Rectangle location = null;
			BorderStyle borderStyle = null;
			
			if (item.getStyle() instanceof BorderStyle) {
				borderStyle = (BorderStyle)item.getStyle();
				int strokeWidth = painter.scale(borderStyle.getBorderStrokeWidth());
				location = new Rectangle(x + strokeWidth, y + strokeWidth, getDrawWidth() - x - strokeWidth , 0);
			}
			else {
				location = new Rectangle(x, y, getDrawWidth() - x, 0);
			}
			
			Rectangle result = painter.draw(item, location);
			
			if(borderStyle != null) {			
				SlidePainter borderpainter = factory.createBorderPainter();		
				int strokeWidth = painter.scale(borderStyle.getBorderStrokeWidth());				
				Rectangle borderLocation = new Rectangle(result.x,result.y, result.width + strokeWidth *2 , result.height + strokeWidth * 2);
				result = borderpainter.draw(item, borderLocation);
			}
			if (result != null) {
				y += result.height + painter.scale(itemSpacing);
			}						
		}
	}	
	
	public void paintComponent(Graphics g) {
		// Paint slide background
		g.setColor(Color.WHITE);		
		g.fillRect(0, 0, getSize().width, getSize().height);	
		g.translate(xMargin, yMargin);
		
		
		if(model != null) {
			PainterFactory factory = AbstractPainterFactory.GraphicsPainter(g, this, getPreferredSize(), parentView.getDefaultSize());  			
			drawSlide(model, factory);
		}
	}
}
