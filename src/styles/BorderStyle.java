package styles;

import java.awt.Color;

/**
 * Interface for styles that need borders
 */
public interface BorderStyle {
	/**
	 * Size of the border stroke.
	 * @return
	 */
	public int getStrokeSize();
	
	/**
	 * Space between the border and the content.
	 * @return
	 */
	public int getPadding();
	
	/**
	 * Color of the border stroke.
	 * @return
	 */
	public Color getStrokeColor();
}
