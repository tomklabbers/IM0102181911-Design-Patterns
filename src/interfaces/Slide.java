package interfaces;

import java.util.Vector;

import model.SlideItem;

public interface Slide {
	public void setTitle(String title);
	
	public String getTitle();
	
	public void addItem(SlideItem item);
	
	public Vector<SlideItem> getItems();
}
