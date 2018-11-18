package styles;

import java.awt.Color;
import java.awt.Font;

/**
 * Interface for styles that use fonts.
 */
public interface FontStyle {
	/**
	 * Color of the font.
	 * @return
	 */
	public Color getFontColor();
	
	/**
	 * Font size.
	 * @return
	 */
	public int getSize();
	
	/**
	 * The font to use.
	 * @param scale
	 * @return
	 */
	public Font getFont(float scale);
}
