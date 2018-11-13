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
	
	public void setSlide(Slide slide) {
		slides.add(slide);
	}
}
