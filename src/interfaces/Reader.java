package interfaces;

import java.util.Vector;

public interface Reader {
	
	public String getTitle();
	
	public Vector<Slide> getSlides();
	
	public void load();

}
