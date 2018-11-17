package interfaces;

import java.util.Vector;

import slideitem.SlideItem;

public interface Slide {
	public void setTitle(String title);
	
	public String getTitle();
	
	public void addItem(SlideItem item);
	
	public Vector<SlideItem> getItems();
	
	public Vector<SlideItem> getRawItems();
	
	public void setMenu(int currentIndex, int maxIndex);
}
