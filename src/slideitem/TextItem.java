package slideitem;

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

class TextItem extends SlideItem implements SlideItemTextValue {	
	private static final String EMPTYTEXT = "No Text Given";
	
	/**
	 * Create textitem with default text value
	 */
	public TextItem() {
		setValue(EMPTYTEXT);
	}

	@Override
	public SlideItemTypes getType() {
		return SlideItemTypes.ITEM_TEXT;
	}
	
	@Override
	public String toString() {
		return "TextItem[" + getStyle()+","+getValue()+"]";
	}

	@Override
	public String getValue() {
		return getRawValue();
	}
	
}
