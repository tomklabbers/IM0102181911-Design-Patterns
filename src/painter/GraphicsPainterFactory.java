package painter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

class GraphicsPainterFactory implements PainterFactory {
	private Graphics canvas;
	private float scale;
	private ImageObserver observer;
	
	public GraphicsPainterFactory(Graphics canvas, ImageObserver observer, Dimension drawArea, Dimension originalArea) {
		this.canvas = canvas;
		this.scale = (float) Math.min(drawArea.getWidth() / originalArea.getWidth(), drawArea.getHeight() / originalArea.getHeight());
	}
	
	@Override
	public SlidePainter createTextPainter() {
		return new GTextPainter(canvas, scale);
	}

	@Override
	public SlidePainter createImagePainter() {
		return new GImagePainter(canvas, scale, observer);
	}
	
	@Override
	public SlidePainter createBorderPainter() {
		return new GBorderPainter(canvas, scale);
	}
}
