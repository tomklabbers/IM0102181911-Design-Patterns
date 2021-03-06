package styles;

import slideitem.SlideItemTypes;

public class StyleFactory {
	/**
	 * Create a style to use with slide items.
	 * 
	 * @param slideItemType
	 * @param hasActions
	 * @param level
	 * @return
	 */
	public static SlideItemStyle createStyle(SlideItemTypes slideItemType, boolean hasActions, int level) {
		switch(slideItemType) {
			case ITEM_MENU:
				return new MenuItemStyle(level);
			case ITEM_TEXT:
				if (hasActions) {
					return new TextItemActionStyle(level);
				}
				else {
					return new TextItemStyle(level);
				}
			case ITEM_IMAGE:
				if (hasActions) {
					return new ImageItemActionStyle(level);
				}
				else {
					return new ImageItemStyle(level);
				}
			default:
				return new DefaultStyle(level);
		}
	}
}
