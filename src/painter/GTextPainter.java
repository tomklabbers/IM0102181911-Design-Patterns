package painter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.awt.geom.Line2D;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import model.SlideItem;

import interfaces.SlideItemTextValue;

import styles.FontStyle;

class GTextPainter extends GraphicsPainter {	
	public GTextPainter(Graphics canvas, float scale) {
		super(canvas,scale);
	}
	
	//geef de AttributedString voor het item
	public AttributedString getAttributedString(String value, FontStyle style, float scale) {
		AttributedString attrStr = new AttributedString(value);
		attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, value.length());
		return attrStr;
	}	
	
	private List<TextLayout> getLayouts(String value, Graphics g, FontStyle s, float width) {
		List<TextLayout> layouts = new ArrayList<TextLayout>(); 
		AttributedString attStr = getAttributedString(value,s, getScale());
    	Graphics2D g2d = (Graphics2D) g;
    	FontRenderContext frc = g2d.getFontRenderContext();
    	LineBreakMeasurer measurer = new LineBreakMeasurer(attStr.getIterator(), frc);
    	while (measurer.getPosition() < value.length()) {
    		TextLayout layout = measurer.nextLayout(width);
    		layouts.add(layout);
    	}
    	return layouts;
	}	
	
	@Override
	public Rectangle draw(SlideItem item, Rectangle location) {
		if (item != null && (item instanceof SlideItemTextValue) && (item.getStyle() instanceof FontStyle)) {
			SlideItemTextValue value = (SlideItemTextValue) item;
			FontStyle fontstyle = (FontStyle) item.getStyle();
			if ( value.getValue() == null || value.getValue().length() == 0) {
				return new Rectangle(0, 0, 0, 20 );
			}
			List<TextLayout> layouts = getLayouts(value.getValue(), getCanvas(), fontstyle, location.getBounds().width);
//			Point pen = new Point(x + (int)(item.getStyle().getIndent() * scale), 
//					y + (int) (myStyle.leading * scale));
			Point pen = location.getBounds().getLocation();
			Graphics2D g2d = (Graphics2D)getCanvas();
			g2d.setFont(fontstyle.getFont(getScale()));
			g2d.setColor(fontstyle.getFontColor());
			Iterator<TextLayout> it = layouts.iterator();
			while (it.hasNext()) {
				TextLayout layout = it.next();
				pen.y += layout.getAscent();
				layout.draw(g2d, pen.x, pen.y);
				pen.y += layout.getDescent();
			}
			return new Rectangle(location.x, location.y, location.width, pen.y - location.y);
		}
		else {
			return new Rectangle();
		}
	}
}
