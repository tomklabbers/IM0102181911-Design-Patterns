package interfaces;

public interface Presentation {
	public void setTitle(String title);
	
	public String getTitle();
	
	public void addSlide(Slide slide);
	
	public void debug();
}
