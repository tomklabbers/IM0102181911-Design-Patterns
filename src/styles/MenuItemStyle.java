package styles;

import java.awt.Color;
import java.awt.Font;

class MenuItemStyle extends SlideItemStyle implements FontStyle {

	public MenuItemStyle(int lvl) {
		super(lvl);
		
		setAlignment(Alignment.RIGHT);
		setLeading(0);
	}

	@Override
	public Color getFontColor() {
		return Color.BLACK;
	}

	@Override
	public int getSize() {
		return 10;
	}

	@Override
	public Font getFont(float scale) {
		Font font = new Font("Dialog", Font.BOLD, getSize());
		return font.deriveFont(getSize() * scale);
	}

}
