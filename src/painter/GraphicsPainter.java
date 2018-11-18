package painter;

import java.awt.Graphics;
import java.awt.Rectangle;

import slideitem.SlideItem;

abstract class GraphicsPainter implements SlidePainter {
	private Graphics canvas;
	private float scale;
	
	public GraphicsPainter(Graphics canvas, float scale) {
		this.canvas = canvas;
		this.scale = scale;
	}
	
	public Graphics getCanvas() {
		return this.canvas;
	}
	
	@Override
	public float getScale() {
		return scale;
	}
	
	@Override
	public int scale(int original) {
		return Math.round(scale * original);
	}
	
	/**
	 * The draw implementation to draw a slide item on a give location.
	 * This method is abstract and needs to be implemented by the specific painter.
	 */
	@Override
	abstract public Rectangle draw(SlideItem item, Rectangle location);
}
