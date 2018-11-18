package painter;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

import slideitem.SlideItem;
import styles.BorderStyle;

/**
 * Paint borders using Graphics
 */
class GBorderPainter extends GraphicsPainter {
	public GBorderPainter(Graphics canvas, float scale) {
		super(canvas, scale);
	}
	
	@Override
	public Rectangle draw(SlideItem item, Rectangle location) {
		if (item.getStyle() instanceof BorderStyle) {
			BorderStyle borderstyle = (BorderStyle) item.getStyle();
			Graphics2D g2d 	= (Graphics2D)getCanvas();
			
			/*
			 * Padding can be set to indicate the space between the
			 * border and the content. 
			 */
			int padding 		= scale(borderstyle.getPadding());
			int strokeSize 	= scale(borderstyle.getStrokeSize());
			
			// Setup the border stroke
			Stroke stroke 	= new BasicStroke(strokeSize);
			g2d.setStroke(stroke);
			g2d.setColor(borderstyle.getStrokeColor());
			
			/*
			 * Strokes are drawn 50% inside the rectangle and 50% outside the rectangle
			 * The stroke size is used to compensate this.
			 */
			getCanvas().drawRect(location.x - strokeSize/2 - padding,location.y - strokeSize/2 - padding,location.width + strokeSize + padding * 2, location.height + strokeSize + padding * 2);
			
			return new Rectangle(location.x - padding - strokeSize,location.y - strokeSize - padding,location.width + padding * 2 + strokeSize * 2, location.height + strokeSize * 2 + padding * 2 );
		}
		else {
			return null;
		}
	}
}
