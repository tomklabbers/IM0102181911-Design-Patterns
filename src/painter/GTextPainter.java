package painter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import interfaces.SlideItemTextValue;
import slideitem.SlideItem;
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
	
	/**
	 * Only prints text when the FonStyle and SlideItemTextValue are implemented
	 * @return Returns rectangle of text dimensions
	 */
	@Override
	public Rectangle draw(SlideItem item, Rectangle location) {
		if (item != null && (item instanceof SlideItemTextValue) && (item.getStyle() instanceof FontStyle)) {
			SlideItemTextValue value = (SlideItemTextValue) item;
			FontStyle fontstyle = (FontStyle) item.getStyle();
			if ( value.getValue() == null || value.getValue().length() == 0) {
				return location;
			}
			List<TextLayout> layouts = getLayouts(value.getValue(), getCanvas(), fontstyle, location.getBounds().width);
			Point pen = location.getBounds().getLocation();
			
			Graphics2D g2d = (Graphics2D)getCanvas();
			g2d.setFont(fontstyle.getFont(getScale()));
			g2d.setColor(fontstyle.getFontColor());
			Iterator<TextLayout> it = layouts.iterator();
			int maxWidth = 0;
			int xPos = pen.x;
			int yPos = pen.y + scale(item.getStyle().getLeading());
			while (it.hasNext()) {
				TextLayout layout = it.next();
				int textWidth = (int) layout.getBounds().getWidth();
				
				switch(item.getStyle().getAlignment()) {
					case RIGHT:
						xPos = location.width - textWidth;
						break;
					case CENTER:
						xPos = pen.x + ((location.width - textWidth)/2);
						break;
					case LEFT:
					default:
						xPos = pen.x;
						break;
				}
				
				yPos += layout.getAscent();
				layout.draw(g2d, xPos, yPos);
				yPos += layout.getDescent();
				
				// Find the widest text line
				maxWidth = Math.max(maxWidth, textWidth);
			}
			return new Rectangle(xPos, location.y, maxWidth, yPos - location.y);
		}
		else {
			return location;
		}
	}
}
