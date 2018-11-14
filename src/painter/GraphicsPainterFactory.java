package painter;

import java.awt.Graphics;
import java.awt.Rectangle;

class GraphicsPainterFactory implements PainterFactory {
	private Graphics canvas;
	private Rectangle drawArea;
	private float scale;
	
	public GraphicsPainterFactory(Graphics canvas, Rectangle drawArea) {
		this.canvas = canvas;
		this.drawArea = drawArea;
		
	}
	
	@Override
	public SlidePainter createTextPainter() {
		return new GTextPainter(canvas);
	}

	@Override
	public SlidePainter createImagePainter() {
		return new GImagePainter(canvas);
	}
	
	@Override
	public SlidePainter createBorderPainter() {
		return new GBorderPainter(canvas);
	}
}
