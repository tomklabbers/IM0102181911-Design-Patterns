package painter;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import slideitem.SlideItem;

abstract class GraphicsPainter  implements SlidePainter {
	private Graphics canvas;
	private float scale;
	
	public GraphicsPainter(Graphics canvas, float scale) {
		this.canvas = canvas;
		this.scale = scale;
	}
	
	public Graphics getCanvas() {
		return this.canvas;
	}
	
	public float getScale() {
		return scale;
	}
	
	public int scale(int original) {
		return Math.round(scale * original);
	}
	
	@Override
	abstract public Rectangle draw(SlideItem item, Rectangle location);

}
