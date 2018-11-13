package painter;

import java.awt.Graphics;

import model.SlideItem;
import javafx.geometry.BoundingBox;

class GBorderPainter extends GraphicsPainter {
	public GBorderPainter(Graphics canvas) {
		super(canvas);
	}
	
	@Override
	public BoundingBox draw(SlideItem item, BoundingBox area) {
		return null;
	}

}
