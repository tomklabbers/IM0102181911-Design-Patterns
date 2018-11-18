package model;

import java.util.Vector;

import slideitem.SlideItem;

/**
 * Interface for slide models
 */
public interface Slide {
	public void setTitle(String title);
	
	public String getTitle();
	
	public void addItem(SlideItem item);
	
	/**
	 * This method is used for getting the slide items to draw.
	 * This includes the items which were created by the slide
	 * itself: title and menu.
	 * 
	 * @return
	 */
	public Vector<SlideItem> getItems();
	
	/**
	 * This method is used by the serializers to get the slide items
	 * that need to be stored as slide items. This method excludes the
	 * custom items created by the slide: title and menu.
	 * 
	 * @return
	 */
	public Vector<SlideItem> getRawItems();
	
	public void setMenu(int currentIndex, int maxIndex);
}
