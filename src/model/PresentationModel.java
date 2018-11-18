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
	
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
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
	
	@Override
	public int getCurrentSlideNumber() {
		/* Offset the slide index because this
		   method is used for display the slide number.
		   Humans count from 1.... */
		return currentSlideIndex + 1;
	}
	
	@Override
	public int getSlideCount() {
		return slides.size();
	}
}
