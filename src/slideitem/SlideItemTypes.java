package slideitem;

public enum SlideItemTypes {
	ITEM_UNKNOWN,
	ITEM_TEXT,
	ITEM_IMAGE,
	ITEM_MENU;

	private static final String ITEM_TEXT_NAME = "text";
	private static final String ITEM_IMAGE_NAME = "image";	
	private static final String ITEM_MENU_NAME = "menu";		
	
	/**
	 * Returns the slide item type by name
	 * @param name of slide item type
	 * @return type of slide item name
	 */
	public static SlideItemTypes getSlideItemType(String name) {
		switch (name) {
		case ITEM_TEXT_NAME:
			return ITEM_TEXT;
		case ITEM_IMAGE_NAME:
			return ITEM_IMAGE;
		case ITEM_MENU_NAME:
			return ITEM_MENU;
		default:
			return ITEM_UNKNOWN;
		}
	}
	
	/**
	 * Returns the slide item type name by type
	 * @param type of slide item type 
	 * @return name of slide item type
	 */
	public static String getSlideItemName(SlideItemTypes type) {
		switch (type) {
		case ITEM_TEXT:
			return ITEM_TEXT_NAME;
		case ITEM_IMAGE:
			return ITEM_IMAGE_NAME;
		case ITEM_MENU:
			return ITEM_MENU_NAME;
		default:
			return "unknown";
		}
	}
}
