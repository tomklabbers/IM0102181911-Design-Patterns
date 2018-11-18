package painter;

import slideitem.SlideItemTypes;

/**
 * Interface for painter factories.
 */
public interface PainterFactory {	
	public SlidePainter createTextPainter();
	public SlidePainter createImagePainter();	
	public SlidePainter createBorderPainter();
	public SlidePainter getPainter(SlideItemTypes type);
}
