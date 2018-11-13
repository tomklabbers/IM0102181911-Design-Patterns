package model;

import java.util.Vector;

import interfaces.Slide;
import interfaces.SlideItem;

public class SlideModel implements Slide {
	private String title;
	
	private Vector<SlideItem> items;
	
	public void setTitle(String title) {
		this.title = title;
	}
}
