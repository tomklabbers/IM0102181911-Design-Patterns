package painter;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import view.PresentationView;

class GraphicsPainterFactory implements PainterFactory {
	private Graphics canvas;
	private Rectangle drawArea;
	private float scale;
	private ImageObserver observer;
	
	public GraphicsPainterFactory(Graphics canvas, Rectangle drawArea, ImageObserver observer) {
		this.canvas = canvas;
		this.drawArea = drawArea;
		this.scale = Math.min(((float)drawArea.width) / ((float)PresentationView.WIDTH), ((float)drawArea.height) / ((float)PresentationView.HEIGHT));
		System.out.println(scale);
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
