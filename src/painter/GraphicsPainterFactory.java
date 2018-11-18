package painter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

import slideitem.SlideItemTypes;

/**
 * GraphicsPainterFactory to create slide item painters.
 * This factory consists of specific creators and an encapsulated creator
 * @author Tom
 *
 */
class GraphicsPainterFactory implements PainterFactory {
	private Graphics canvas;
	private float scale;
	private ImageObserver observer;
	
	public GraphicsPainterFactory(Graphics canvas, ImageObserver observer, Dimension drawArea, Dimension originalArea) {
		this.canvas = canvas;
		this.scale = (float) Math.min(drawArea.getWidth() / originalArea.getWidth(), drawArea.getHeight() / originalArea.getHeight());
	}
	
	/**
	 * Specific painter creator: TextPainter
	 */
	@Override
	public SlidePainter createTextPainter() {
		return new GTextPainter(canvas, scale);
	}
	
	/**
	 * Specific painter creator: ImagePainter
	 */
	@Override
	public SlidePainter createImagePainter() {
		return new GImagePainter(canvas, scale, observer);
	}
	
	/**
	 * Specific painter creator: BorderPainter
	 * 
	 * Note: This painter can only be created with this method
	 * Borders are possible for multiple slide items.
	 */
	@Override
	public SlidePainter createBorderPainter() {
		return new GBorderPainter(canvas, scale);
	}
	
	/**
	 * Encapsulated painter creator. This method creates a painter based
	 * on the given slide item type.
	 */
	@Override
	public SlidePainter getPainter(SlideItemTypes type) {
		switch (type) {
			case ITEM_MENU:
			case ITEM_TEXT:
				return createTextPainter();				
			case ITEM_IMAGE:
				return createImagePainter();
			case ITEM_UNKNOWN:
			default:
				return null;
		}
	}
}
