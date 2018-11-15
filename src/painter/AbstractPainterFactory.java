package painter;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public final class AbstractPainterFactory {
	public static PainterFactory GraphicsPainter(Graphics canvas, Rectangle drawArea, ImageObserver observer){
		return new GraphicsPainterFactory(canvas, drawArea, observer);
	}
}
