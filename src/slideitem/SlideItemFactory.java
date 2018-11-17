package slideitem;

public class SlideItemFactory {
	
	/**
	 * 
	 * @param type 
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
	
	public static SlideItem createSlideItem(String type) {
		return createSlideItem(SlideItemTypes.getSlideItemType(type));
	}
	
	public static SlideItem createMenuItem(int currentIndex, int maxIndex) {
		SlideItem item = createSlideItem(SlideItemTypes.ITEM_MENU);	
		if (item instanceof SlideItemMenuItemValue) {
			((SlideItemMenuItemValue) item).setIndexes(currentIndex, maxIndex);
		}
		return item;
	}
}