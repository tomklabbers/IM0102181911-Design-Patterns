package model;

import java.util.Vector;


public class PresentationModel implements Presentation {
	String title = "untitled";
	int currentSlideIndex;
	Vector<Slide> slides;
	
	public PresentationModel() {
		slides = new Vector<Slide>();
		currentSlideIndex = 0;
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
	public boolean nextSlide() {
		if(currentSlideIndex < slides.size()-1) {
			currentSlideIndex++;
			return true;
		}
		return false;
	}

	@Override
	public boolean prevSlide() {
		if(currentSlideIndex > 0) {
			currentSlideIndex--;
			return true;
		}
		return false;
	}

	@Override
	public boolean goToSlide(int index) {
		if(index >= 0 &&
		   index < slides.size() &&
		   index != currentSlideIndex) {
			currentSlideIndex = index;
			return true;
		}
		return false;
	}

	@Override
	public Slide getCurrentSlide() {
		if(slides.size() > 0) {
			return slides.elementAt(currentSlideIndex);
		}
		
		return null;
	}

	@Override
	public Vector<Slide> getSlides() {
		return slides;
	}
	
	public int getCurrentSlideNumber() {
		return currentSlideIndex + 1;
	}
	
	public int getSlideCount() {
		return slides.size();
	}
}
