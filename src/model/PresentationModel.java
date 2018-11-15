package model;

import java.util.Vector;

import interfaces.Presentation;
import interfaces.Slide;


public class PresentationModel implements Presentation {
	String title = "untitled";
	
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

	@Override
	public void nextSlide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prevSlide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goToSlide(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Slide getCurrentSlide() {
		// TODO Add logic
		return slides.firstElement();
	}

	@Override
	public Vector<Slide> getSlides() {
		return slides;
	}
}
