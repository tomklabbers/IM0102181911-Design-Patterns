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
			Graphics2D g2d 	= (Graphics2D)getCanvas();
			int strokeSize 	= scale(borderstyle.getStrokeSize());
			int padding 		= scale(borderstyle.getPadding());
			Stroke stroke 	= new BasicStroke(strokeSize);
			
			g2d.setStroke(stroke);
			g2d.setColor(borderstyle.getStrokeColor());
			
			
			getCanvas().drawRect(location.x - strokeSize/2 - padding,location.y - strokeSize/2 - padding,location.width + strokeSize + padding * 2, location.height + strokeSize + padding * 2);
			
			return new Rectangle(location.x - padding - strokeSize,location.y - strokeSize - padding,location.width + padding * 2 + strokeSize * 2, location.height + strokeSize * 2 + padding * 2 );
		}
		else {
			return null;
		}
		
	}
}
