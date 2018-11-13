package model;

import java.util.Vector;

import interfaces.*;

public class PresentationModel implements Presentation {
	String title;
	
	Vector<Slide> slides;
	
	public PresentationModel() {
		slides = new Vector<Slide>();
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void addSlide(Slide slide) {
		slides.add(slide);
	}
	
	public void debug() {
		System.out.println("Presentation: "+getTitle());
		System.out.println("Num of Slides: "+slides.size());
		int i, j; Slide s; SlideItem item;
		for(i = 0; i<slides.size(); i++) {
			s = slides.get(i);
			Vector<SlideItem> items = s.getItems();
			System.out.println("- Slide: "+s.getTitle()+" items: "+items.size());
			
			for(j = 0; j<items.size(); j++) {
				item = items.get(j);
				System.out.println("-- Item: "+item.getType()+" level: "+item.getLevel()+" value: "+item.getRawValue());
			}
		}
	}
}
