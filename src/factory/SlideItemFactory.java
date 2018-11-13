package factory;

import interfaces.SlideItem;
import model.TextItem;

public class SlideItemFactory {
	
	protected static final String TYPE_TEXT = "text";
    protected static final String TYPE_IMAGE = "image";
	
	public static SlideItem createSlideItem(String type, int level) {
		if(type == null) { return null; }
		
		SlideItem item = null;
		
		if(TYPE_TEXT.equals(type)) {
			item = new TextItem();
			
		}
		else if(TYPE_IMAGE.equals(type)) {
			item = new TextItem();
		}
		
		if(item != null) {
			item.setLevel(level);
		}
		
		
		return item;
	}
}