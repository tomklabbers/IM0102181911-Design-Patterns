package model;

import interfaces.SlideItemTextValue;

/** <p>Een tekst item.</p>
 * <p>Een TextItem heeft tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class TextItem extends SlideItem implements SlideItemTextValue {
	
	private static final String EMPTYTEXT = "No Text Given";

// een textitem van level level, met als tekst string
	public TextItem(int level) {
		super(level);
	}

	@Override
	public String getType() {
		return "text";
	}
// een leeg textitem
	public TextItem() {
		this(0);
	}
	public String toString() {
		return "TextItem[" + getLevel()+","+getValue()+"]";
	}

	@Override
	public String getValue() {
		return getRawValue();
	}
	
}
