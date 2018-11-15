package styles;

import java.awt.Color;
import java.awt.Font;

public class TextItemStyle extends SlideItemStyle implements FontStyle {
	private static final String FONTNAME = "Helvetica";
	public TextItemStyle(int lvl) {
		super(lvl);
	}	
	
	@Override
	public int getIndent() {
		if (getLevel() == 0) {
			return 0;
		}
		else {
			return getLevel() * 20 + 10;
		}
	}
	
	@Override
	public Font getFont(float scale) {
		if (getLevel() == 0)
			return new Font(FONTNAME, Font.BOLD, 20);
		else {
			return new Font(FONTNAME, Font.BOLD, 10);
		}
	}@Override
	
	public int getSize() {
		return 0;
	}
	
	@Override
	public Color getFontColor() {
		switch (getLevel()) {
		case 0:
			return Color.RED;
		case 1:
			return Color.blue;
		default:
			return Color.black;
		}
	}

}
