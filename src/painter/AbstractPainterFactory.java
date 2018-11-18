package painter;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.ImageObserver;

/**
 * AbstractPainterFactory creates a specific painter factory for the request implementation.
 *
 */
public final class AbstractPainterFactory {
	
	/**
	 * Create a painter factory which creates painters to paint on a Graphic instance.
	 * 
	 * @param canvas Graphics The Graphics instance to paint on.
	 * @param observer ImageObserver Needed to paint images.
	 * @param drawArea Dimension The area wherein the painter can paint.
	 * @param originalArea Dimension The original size of the draw area. This is used to calculate the draw scale.
	 * 
	 * @return GraphicsPainterFactory
	 */
	public static PainterFactory GraphicsPainter(Graphics canvas, ImageObserver observer, Dimension drawArea, Dimension originalArea){
		return new GraphicsPainterFactory(canvas, observer, drawArea, originalArea);
	}
}
