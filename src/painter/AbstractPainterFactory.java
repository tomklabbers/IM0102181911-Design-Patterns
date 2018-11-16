package painter;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.ImageObserver;

public final class AbstractPainterFactory {
	public static PainterFactory GraphicsPainter(Graphics canvas, ImageObserver observer, Dimension drawArea, Dimension originalArea){
		return new GraphicsPainterFactory(canvas, observer, drawArea, originalArea);
	}
}
