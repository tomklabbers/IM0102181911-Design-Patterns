package styles;

import java.awt.Color;

class TextItemActionStyle extends TextItemStyle implements FontStyle, BorderStyle{
	private static Color borderColor = Color.black;
	private static int strokeSize = 3;
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
