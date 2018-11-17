package painter;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Line2D;

import slideitem.SlideItem;
import styles.BorderStyle;

class GBorderPainter extends GraphicsPainter {
	public GBorderPainter(Graphics canvas, float scale) {
		super(canvas, scale);
	}
	
	@Override
	public Rectangle draw(SlideItem item, Rectangle location) {
		if (item.getStyle() instanceof BorderStyle) {
			BorderStyle borderstyle = (BorderStyle) item.getStyle();
			Graphics2D g2d = (Graphics2D)getCanvas();
			Stroke stroke = new BasicStroke(borderstyle.getBorderStrokeWidth());
			g2d.setStroke(stroke);
			g2d.setColor(borderstyle.getBorderColor());
			getCanvas().drawRect(location.x,location.y,location.width, location.height);
			return new Rectangle(location);
		}
		else {
			return null;
		}
		
	}
}
