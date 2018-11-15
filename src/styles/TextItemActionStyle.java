package styles;

import java.awt.Color;
import java.awt.Font;

public class TextItemActionStyle extends TextItemStyle implements FontStyle, BorderStyle{

	public TextItemActionStyle(int lvl) {
		super(lvl);
		
	}
	
	@Override
	public Color getBorderColor() {
		// TODO Auto-generated method stub
		return Color.black;
	}
	
	@Override
	public int getBorderStrokeWidth() {
		// TODO Auto-generated method stub
		return 5;
	}
}
