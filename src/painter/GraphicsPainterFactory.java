package painter;

import java.awt.Graphics;

class GraphicsPainterFactory implements PainterFactory {
	private Graphics canvas;
	
	public GraphicsPainterFactory(Graphics canvas) {
		this.canvas = canvas;
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
