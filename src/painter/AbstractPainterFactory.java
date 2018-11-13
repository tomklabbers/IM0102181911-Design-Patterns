package painter;

import java.awt.Graphics;

public final class AbstractPainterFactory {
	public static PainterFactory GraphicsPainter(Graphics canvas){
		return new GraphicsPainterFactory(canvas);
	}
}
