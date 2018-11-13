package model;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import styles.SlideItemStyle;

/** <p>De abstracte klasse voor een item op een Slide<p>
 * <p>Alle SlideItems hebben tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public abstract class SlideItem {
	private int level = 0; // het level van het slideitem
	private SlideItemStyle style;
	private String value;

	public SlideItem(int lev) {
		level = lev;
	}

	public SlideItem() {
		this(0);
	}

// Geef het level
	public int getLevel() {
		return level;
	}
	
	public abstract String getType();
	
	public SlideItemStyle getStyle() {
		return this.style;
	}
	
	public void setStyle(SlideItemStyle style) {
		this.style = style;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getRawValue() {
		return value;
	}
}
