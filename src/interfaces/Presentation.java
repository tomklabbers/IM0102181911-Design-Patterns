package interfaces;

import java.util.Vector;

public interface Presentation {
	public void setTitle(String title);
	
	public String getTitle();
	
	public void addSlide(Slide slide);
	
	public void nextSlide();
	
	public void prevSlide();
	
	public void goToSlide(int index);
	
	public Slide getCurrentSlide();
	
	public Vector<Slide> getSlides();
}
