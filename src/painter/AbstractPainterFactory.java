package painter;

import java.awt.Graphics;
import java.awt.geom.Point2D;

public final class AbstractPainterFactory {
	public static PainterFactory GraphicsPainter(Graphics canvas, Point2D area){
		return new GraphicsPainterFactory(canvas);
	}
}
