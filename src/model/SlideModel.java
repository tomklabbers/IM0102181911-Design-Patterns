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
		// Slide titles are converted to slide items. 
		this.title = SlideItemFactory.createSlideItem(SlideItemTypes.ITEM_TEXT);
		
		// Set the style for this item.
		this.title.setStyle(StyleFactory.createStyle(this.title.getType(), false, 0));
		
		this.title.setValue(title);
	}
	
	@Override
	public void setMenu(int currentIndex, int maxIndex) {
		// Create a slide item for the menu.
		menu = SlideItemFactory.createMenuItem(currentIndex, maxIndex);
		
		// Set the style for this item.
		menu.setStyle(StyleFactory.createStyle(menu.getType(), false, 0));
	}
	
	@Override
	public String getTitle() {
		// getRawValue returns the value set when the slide item was created.
		return title.getRawValue();
	}
	
	@Override
	public void addItem(SlideItem item) {
		items.add(item);
	}
	
	/**
	 * @see Slide interface
	 */
	@Override
	public Vector<SlideItem> getItems() {
		// Make a copy of the slide items.
		Vector<SlideItem> tmp = new Vector<SlideItem>(items);
		
		// Add the custom slide items title and menu.
		tmp.add(0, title);
		tmp.add(0, menu);
		
		return tmp;
	}
	
	/**
	 * @see Slide interface
	 */
	@Override
	public Vector<SlideItem> getRawItems() {
		return items;
	}
}
