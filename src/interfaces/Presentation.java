package interfaces;

public interface Presentation {
	public void setTitle(String title);
	
	public String getTitle();
	
	public void addSlide(Slide slide);
	
	public void debug();
	
	public void nextSlide();
	
	public void prevSlide();
	
	public void goToSlide(int index);
	
	public void getCurrentSlide();
}
