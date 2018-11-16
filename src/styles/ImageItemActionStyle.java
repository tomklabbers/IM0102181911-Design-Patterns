package styles;

import java.awt.Color;

public class ImageItemActionStyle extends SlideItemStyle implements BorderStyle{
	private static Color borderColor = Color.BLUE;
	private static int strokeWidth = 5;
	public ImageItemActionStyle(int lvl) {
		super(lvl);
	}
	@Override
	public int getIndent() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Color getBorderColor() {
		return borderColor;
	}
	
	@Override
	public int getBorderStrokeWidth() {
		return strokeWidth;
	}

}
