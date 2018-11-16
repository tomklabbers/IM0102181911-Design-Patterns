package painter;

import java.awt.Rectangle;
import java.awt.geom.Line2D;

import model.SlideItem;

public interface SlidePainter {
	abstract public Rectangle draw(SlideItem item, Rectangle location);
	
	public int scale(int original);
}
