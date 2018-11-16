package styles;

import java.awt.Color;
import java.awt.Font;

import styles.SlideItemStyle.Alignment;

public class TextItemActionStyle extends TextItemStyle implements FontStyle, BorderStyle{
	private static Color borderColor = Color.black;
	private static int strokeWidth = 3;
	
	public TextItemActionStyle(int lvl) {
		super(lvl);
		
		setAlignment(Alignment.LEFT);
	}
	
	@Override
	public Color getBorderColor() {
		return borderColor;
	}
	
	@Override
	public int getBorderStrokeWidth() {
		return Math.round(strokeWidth);
	}
}
