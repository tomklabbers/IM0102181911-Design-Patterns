package painter;

import java.awt.Rectangle;

import slideitem.SlideItem;

/**
 * Interface for slide painters
 */
public interface SlidePainter {
	abstract public Rectangle draw(SlideItem item, Rectangle location);
	
	public float getScale();
	
	/**
	 * Apply the scale on a given number
	 * 
	 * @return int The scaled number
	 */
	public int scale(int original);
}
