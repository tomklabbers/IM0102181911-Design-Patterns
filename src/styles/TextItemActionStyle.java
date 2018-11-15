package styles;

import java.awt.Color;
import java.awt.Font;

public class TextItemActionStyle extends SlideItemStyle implements FontStyle, BorderStyle{

	public TextItemActionStyle(int lvl) {
		super(lvl);
	}
	
	@Override
	public Font getFont(float scale) {
		// TODO Auto-generated method stub
		return null;
	}@Override
	
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Color getFontColor() {
		return Color.BLACK;
	}
	
	@Override
	public Color getBorderColor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getBorderStrokeWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
