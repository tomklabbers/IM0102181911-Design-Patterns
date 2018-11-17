package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
import javax.swing.JComponent;

import interfaces.Slide;
import painter.AbstractPainterFactory;
import painter.PainterFactory;
import painter.SlidePainter;
import slideitem.SlideItem;
import styles.BorderStyle;

public class SlideView extends JComponent {
	
	private static final long serialVersionUID = 1L;
	
	private static final int yMargin 	= 10;
	private static final int xMargin 	= 0;
	
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
	
	public void clear() {
		model = null;
		
		repaint();
	}
	
	private Point getRealXY(int x, int y) {
		return new Point(x - xMargin, y - yMargin);
	}
	
	public SlideItem getItemAtPos(int x, int y) {
		for (Map.Entry<Rectangle, SlideItem> item : itemLookup.entrySet()) {
			if (item.getKey().contains(getRealXY(x, y))) {
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
		int y = 0;
		itemLookup = new HashMap<Rectangle, SlideItem>();
		for (SlideItem item : slide.getItems()) {
			SlidePainter painter = factory.getPainter(item.getType());
				
			if (painter == null) {
				continue;
			}
			Rectangle location = null;
			BorderStyle borderStyle = null;
			
			if (item.getStyle() instanceof BorderStyle) {
				borderStyle = (BorderStyle)item.getStyle();
				// Border scale!
				int stroke 	= painter.scale(borderStyle.getStrokeSize());
				int padding 	= painter.scale(borderStyle.getPadding());
				
				location = new Rectangle(0 + padding + stroke, y + padding + stroke, getDrawWidth(), 0);
			}
			else {
				location = new Rectangle(0, y, getDrawWidth(), 0);
			}
			
			Rectangle result = painter.draw(item, location);

			if(borderStyle != null) {			
				SlidePainter borderpainter = factory.createBorderPainter();
				result = borderpainter.draw(item, result);
			}
			
			itemLookup.put(result, item);
			
			if (result != null) {
				y = result.height + result.y ;
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
