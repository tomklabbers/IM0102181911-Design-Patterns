package styles;

import java.awt.Color;
import java.awt.Font;

public class TextItemStyle extends SlideItemStyle implements FontStyle {
	private static final String FONTNAME = "Helvetica";
	private Font font;
	private int fontsize;
	public TextItemStyle(int lvl) {
		super(lvl);
		if (getLevel() == 0)
			fontsize = 48;
		else {
			fontsize = 32;
		}		
		font = new Font(FONTNAME, Font.BOLD, fontsize);
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
		return font.deriveFont(fontsize * scale);

	}@Override
	
	public int getSize() {
		return fontsize;
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
