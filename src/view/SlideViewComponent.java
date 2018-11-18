package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

import model.Slide;
import painter.AbstractPainterFactory;
import painter.PainterFactory;
import painter.SlidePainter;
import slideitem.SlideItem;
import styles.BorderStyle;

/**
 * SlideViewComponent is used as view to display a slide.
 *
 */
public class SlideViewComponent extends SlideView {
	private static final long serialVersionUID = 1L;
	private static final int yMargin 	= 10;
	private static final int xMargin 	= 0;
	
	private Slide model;
	private Map<Rectangle, SlideItem> itemLookup;
	private PresentationView parentView;
	
	public SlideViewComponent(PresentationView view) {
		super();
		
		this.parentView = view;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(getParent().getWidth(), getParent().getHeight());
	}
	
	@Override
	public void setSlide(Slide slide) {
		model = slide;
		
		repaint();
	}
	
	@Override
	public void clear() {
		model = null;
		
		repaint();
	}
	
	@Override
	public SlideItem getItemAtPos(int x, int y) {
		for (Map.Entry<Rectangle, SlideItem> item : itemLookup.entrySet()) {
			if (item.getKey().contains(getRealXY(x, y))) {
				return item.getValue();
			}
		}
		return null;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// Paint slide background
		g.setColor(Color.WHITE);		
		g.fillRect(0, 0, getSize().width, getSize().height);	
		
		// Use translate to apply margin around entire slide.
		g.translate(xMargin, yMargin);
		
		if(model != null) {
			// Create a painter factory which can be used with a Graphics instance
			PainterFactory factory = AbstractPainterFactory.GraphicsPainter(g, this, getPreferredSize(), parentView.getDefaultSize());  			
			
			// Draw all the slide items.
			drawSlide(model, factory);
		}
	}
	
	/**
	 * Get the max width a slide item can be drawn in.
	 * 
	 * @return int The max width.
	 */
	private int getDrawWidth() {
		// xMargin is applied two times, left and right
		return getSize().width - (xMargin * 2);
	}
	
	/**
	 * Draw all slide items using a slide and specific painter.
	 * 
	 * @param slide
	 * @param factory
	 */
	private void drawSlide(Slide slide, PainterFactory factory) {
		int y = 0;
		itemLookup = new HashMap<Rectangle, SlideItem>();
		
		// Loop through all slide items to draw them individually.
		for (SlideItem item : slide.getItems()) {
			/* Get the painter for this slide item.
			   the painter is created by a painter factory
			   which is created for drawing with a Graphic instance. */
			SlidePainter painter = factory.getPainter(item.getType());
			
			// No painter for this slide item, skip the item.
			if (painter == null) {
				continue;
			}
			
			Rectangle location = null;
			BorderStyle borderStyle = null;
			
			if (item.getStyle() instanceof BorderStyle) {
				// Prepare draw location for a border if a border is needed
				borderStyle = (BorderStyle)item.getStyle();
				
				int stroke 	= painter.scale(borderStyle.getStrokeSize());
				int padding 	= painter.scale(borderStyle.getPadding());
				
				// location needs to be adjusted using the padding and stroke to keep bordered items
				// aligned with other items in the same level.
				location = new Rectangle(0 + padding + stroke, y + padding + stroke, getDrawWidth(), 0);
			}
			else {
				// Prepare draw location
				location = new Rectangle(0, y, getDrawWidth(), 0);
			}
			
			// Draw the slide item.
			Rectangle result = painter.draw(item, location);
			
			if(borderStyle != null) {
				// Draw a border around the item to indicate an action
				SlidePainter borderpainter = factory.createBorderPainter();
				result = borderpainter.draw(item, result);
			}
			
			// Store the item location to handle click action
			itemLookup.put(result, item);
			
			// Increase the y position after a successful draw
			if (result != null) {
				y = result.height + result.y ;
			}						
		}
	}	
	
	/**
	 * Transforms a coordinate to the translated coordinate context
	 * 
	 * @param x
	 * @param y
	 * @return Point the click coordinate
	 */
	private Point getRealXY(int x, int y) {
		return new Point(x - xMargin, y - yMargin);
	}
}
