package accessor;

import java.util.Vector;

import interfaces.Presentation;
import interfaces.Slide;

public class DemoReader implements PresentationReader {
	
	public void load(Presentation presentation) {
		presentation.setTitle("This is a DEMO Presentation!!1!");
	}

}

