package factory;


import model.BitmapItem;
import model.MenuItem;
import model.SlideItem;
import model.TextItem;
import styles.StyleFactory;

public class SlideItemFactory {
	
	protected static final String TYPE_TEXT = "text";
    protected static final String TYPE_IMAGE = "image";
	
	public static SlideItem createSlideItem(String type, int level) {
		if(type == null) { return null; }
		
		SlideItem item = null;
		
		if(TYPE_TEXT.equals(type)) {
			item = new TextItem(level);
			
		}
		else if(TYPE_IMAGE.equals(type)) {
			item = new BitmapItem(level);
		}
		item.setStyle(StyleFactory.createStyle(type, true, level));
		
		return item;
	}
	
	public static SlideItem createMenuItem(int currentIndex, int maxIndex) {
		SlideItem item = new MenuItem(0, currentIndex, maxIndex);
		item.setStyle(StyleFactory.createStyle("menu", true, 0));
		
		return item;
	}
}