package model;

import java.util.Vector;

import slideitem.SlideItem;
import slideitem.SlideItemFactory;
import slideitem.SlideItemTypes;
import styles.StyleFactory;

public class SlideModel implements Slide {
	private SlideItem title;
	private SlideItem menu;
	
	private Vector<SlideItem> items;
	
	public SlideModel() {
		items = new Vector<SlideItem>();
	}
	
	public void setTitle(String title) {
		this.title = SlideItemFactory.createSlideItem(SlideItemTypes.ITEM_TEXT);
		this.title.setStyle(StyleFactory.createStyle(this.title.getType(), false, 0));
		this.title.setValue(title);
	}
	
	public void setMenu(int currentIndex, int maxIndex) {
		menu = SlideItemFactory.createMenuItem(currentIndex, maxIndex);
		menu.setStyle(StyleFactory.createStyle(menu.getType(), false, 0));
	}
	
	public String getTitle() {
		return title.getRawValue();
	}
	
	public void addItem(SlideItem item) {
		items.add(item);
	}

	@Override
	public Vector<SlideItem> getItems() {
		Vector<SlideItem> tmp = new Vector<SlideItem>(items);
		tmp.add(0, title);
		tmp.add(0, menu);
		
		return tmp;
	}

	@Override
	public Vector<SlideItem> getRawItems() {
		return items;
	}
}
