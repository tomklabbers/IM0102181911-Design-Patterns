package model;

import java.util.Vector;

import interfaces.Slide;
import interfaces.SlideItem;

public class SlideModel implements Slide {
	private String title;
	
	private Vector<SlideItem> items;
	
	public SlideModel() {
		items = new Vector<SlideItem>();
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void addItem(SlideItem item) {
		items.add(item);
	}

	@Override
	public Vector<SlideItem> getItems() {
		return items;
	}
}
