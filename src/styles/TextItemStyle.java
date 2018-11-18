package styles;

import java.awt.Color;
import java.awt.Font;

/**
 * Default style for text items.
 */
class TextItemStyle extends SlideItemStyle implements FontStyle {
	private static final String FONTNAME = "Helvetica";
	private Font font;
	public TextItemStyle(int lvl) {
		super(lvl);	
	}	
	
	@Override
	public Font getFont(float scale) {
		font = new Font(FONTNAME, Font.BOLD, getSize());
		return font.deriveFont(getSize() * scale);

	}
	
	@Override
	public int getSize() {
		switch (getLevel()) {
			case 0:
				return 48;
			case 1:
				return 40;
			case 2:
				return 36;
			case 3:
				return 30;
			case 4:
			default:
				return 24;
		}
	}
	
	@Override
	public Color getFontColor() {
		switch (getLevel()) {
		case 0:
			return Color.red;
		case 1:
			return Color.blue;
		default:
			return Color.black;
		}
	}

}
