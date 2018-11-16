package interfaces;

import java.util.Vector;

public interface Presentation {
	public void setTitle(String title);
	
	public String getTitle();
	
	public void addSlide(Slide slide);
	
	public boolean nextSlide();
	
	public boolean prevSlide();
	
	public boolean goToSlide(int index);
	
	public Slide getCurrentSlide();
	
	public int getCurrentSlideNumber();
	
	public int getSlideCount();
	
	public Vector<Slide> getSlides();
}
