package model;
import java.util.Vector;

import interfaces.Reader;
import interfaces.Slide;

public class DemoReader implements Reader {
	
	public void DemoReader() {}
	
	public String getTitle() {
		return "DEMO Presentation!";
	}
	
	public Vector<Slide> getSlides() {
		return null;
	}
	
	public void load() {
		// Does nothing.
	}

}
