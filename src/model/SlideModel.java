package model;

import java.util.Vector;

import factory.SlideItemFactory;
import interfaces.Slide;
import model.SlideItem;

public class SlideModel implements Slide {
	private SlideItem title;
	
	private Vector<SlideItem> items;
	
	public SlideModel() {
		items = new Vector<SlideItem>();
	}
	
	public void setTitle(String title) {
		this.title = SlideItemFactory.createSlideItem("text", 0);
		this.title.setValue(title);
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
		
		return tmp;
	}

	@Override
	public Vector<SlideItem> getRawItems() {
		return items;
	}
}
