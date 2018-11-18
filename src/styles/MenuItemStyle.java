package styles;

import java.awt.Color;
import java.awt.Font;

/**
 * Style for the menu item. Menu item is special. This item uses
 * a right alignment.
 */
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
		return 11;
	}
	
	@Override
	public int getIndent() {
		return 50;
	}

	@Override
	public Font getFont(float scale) {
		Font font = new Font("Dialog", Font.BOLD, getSize());
		return font.deriveFont(getSize() * scale);
	}

}
