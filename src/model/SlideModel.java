package model;

import java.util.Vector;

import factory.SlideItemFactory;
import interfaces.Slide;
import model.SlideItem;

public class SlideModel implements Slide {
	private SlideItem title;
	private SlideItem menu;
	
	private Vector<SlideItem> items;
	
	public SlideModel() {
		items = new Vector<SlideItem>();
	}
	
	public void setTitle(String title) {
		this.title = SlideItemFactory.createSlideItem("text", 0);
		this.title.setValue(title);
	}
	
	public void setMenu(int currentIndex, int maxIndex) {
		menu = SlideItemFactory.createMenuItem(currentIndex, maxIndex);
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
