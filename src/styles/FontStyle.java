package styles;

import java.awt.Color;
import java.awt.Font;

public interface FontStyle {
	public Color getFontColor();
	public int getSize();
	public Font getFont(float scale);
}
