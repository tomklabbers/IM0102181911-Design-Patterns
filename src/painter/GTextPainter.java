package painter;

import model.SlideItem;
import javafx.geometry.BoundingBox;
import java.awt.Graphics;

class GTextPainter extends GraphicsPainter {	
	public GTextPainter(Graphics canvas) {
		super(canvas);
	}
	
	@Override
	public BoundingBox draw(SlideItem item, BoundingBox area) {
//		if (item == null || item.getValue() == null || item.getValue().length() == 0) {
//			return new BoundingBox(0, 0, 0, 0);
//		}
//		List<TextLayout> layouts = getLayouts(g, myStyle, scale);
//		Point pen = new Point(x + (int)(myStyle.indent * scale), 
//				y + (int) (myStyle.leading * scale));
//		Graphics2D g2d = (Graphics2D)g;
//		g2d.setColor(myStyle.color);
//		Iterator<TextLayout> it = layouts.iterator();
//		while (it.hasNext()) {
//			TextLayout layout = it.next();
//			pen.y += layout.getAscent();
//			layout.draw(g2d, pen.x, pen.y);
//			pen.y += layout.getDescent();
//		}
//	}
	 return null;
	}
}
