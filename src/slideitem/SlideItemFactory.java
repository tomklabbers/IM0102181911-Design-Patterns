package slideitem;

public class SlideItemFactory {
	
	/**
	 * Create a slide item based on the type (Uses the enumeration)
	 * 
	 * @param type SlideItemType
	 * @return
	 */
	public static SlideItem createSlideItem(SlideItemTypes type) {		
		switch (type) {
		case ITEM_IMAGE:
			return new BitmapItem();
		case ITEM_TEXT:
			return new TextItem();
		case ITEM_MENU:
			return new MenuItem();
		default:
			return null;
		}
	}
	
	/**
	 * Create a slide item based on the type
	 * 
	 * @param type String the type as String 
	 * @return
	 */
	public static SlideItem createSlideItem(String type) {
		return createSlideItem(SlideItemTypes.getSlideItemType(type));
	}
	
	/**
	 * Create a menu item. This is a special item.
	 * 
	 * @param currentIndex
	 * @param maxIndex
	 * @return
	 */
	public static SlideItem createMenuItem(int currentIndex, int maxIndex) {
		SlideItem item = createSlideItem(SlideItemTypes.ITEM_MENU);	
		if (item instanceof SlideItemMenuItemValue) {
			((SlideItemMenuItemValue) item).setIndexes(currentIndex, maxIndex);
		}
		return item;
	}
}