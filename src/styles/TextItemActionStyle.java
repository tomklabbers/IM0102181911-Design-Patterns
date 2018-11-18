package styles;

import java.awt.Color;

/**
 * Style for a text item with action.
 */
class TextItemActionStyle extends TextItemStyle implements FontStyle, BorderStyle{
	private static Color borderColor = Color.black;
	private static int strokeSize = 3;
	
	// Padding between border and the text.
	private static int padding = 5;
	
	public TextItemActionStyle(int lvl) {
		super(lvl);
	}
	
	@Override
	public Color getStrokeColor() {
		return borderColor;
	}
	
	@Override
	public int getStrokeSize() {
		return strokeSize;
	}

	@Override
	public int getPadding() {
		return padding;
	}
}
