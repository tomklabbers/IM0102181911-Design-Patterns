package painter;

import java.awt.Graphics;

import model.SlideItem;
import javafx.geometry.BoundingBox;

abstract class GraphicsPainter  implements SlidePainter {
	private Graphics canvas;
	
	public GraphicsPainter(Graphics canvas) {
		this.canvas = canvas;
	}
	
	public Graphics getCanvas() {
		return this.canvas;
	}
	
	@Override
	abstract public BoundingBox draw(SlideItem item, BoundingBox area);

}
