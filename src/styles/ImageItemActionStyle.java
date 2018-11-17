package styles;

import java.awt.Color;

class ImageItemActionStyle extends SlideItemStyle implements BorderStyle{
	private static Color borderColor = Color.BLUE;
	private static int strokeSize = 5;
	private static int padding = 0;
	public ImageItemActionStyle(int lvl) {
		super(lvl);
		
		setAlignment(Alignment.LEFT);
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
