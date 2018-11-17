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
	public Rectangle draw(SlideItem item, Rectangle drawArea) {
		if (item != null && (item instanceof SlideItemTextValue) && (item.getStyle() instanceof FontStyle)) {
			SlideItemTextValue value = (SlideItemTextValue) item;
			
			FontStyle fontstyle = (FontStyle) item.getStyle();
			Graphics2D g2d = (Graphics2D)getCanvas();
			g2d.setFont(fontstyle.getFont(getScale()));
			g2d.setColor(fontstyle.getFontColor());
			
			List<TextLayout> layouts = getLayouts(value.getValue(), getCanvas(), fontstyle, drawArea.width);
			Iterator<TextLayout> it = layouts.iterator();
			
			Point pen = new Point(drawArea.x, drawArea.y + scale(item.getStyle().getLeading()));
			
			int yStart = pen.y; // Store original y position to calculate height after draw
			int indentation = scale(item.getStyle().getIndent());
			int maxWidth = 0;
			
			while (it.hasNext()) {
				TextLayout layout = it.next();
				int textWidth = (int)layout.getBounds().getWidth();
				
				switch(item.getStyle().getAlignment()) {
					case RIGHT:
						pen.x = (drawArea.width - textWidth) - indentation;
						break;
					case CENTER:
						pen.x = ((drawArea.width - textWidth)/2);
						break;
					case LEFT:
					default:
						pen.x = drawArea.x + indentation;
						break;
				}
				
				pen.y += layout.getAscent();
				layout.draw(g2d, pen.x, pen.y);
				pen.y += layout.getDescent();
				
				// Find the widest text line
				maxWidth = Math.max(maxWidth, textWidth);
			}

			return new Rectangle(pen.x, yStart, maxWidth, pen.y - yStart);
		}
		else {
			return drawArea;
		}
	}
}
