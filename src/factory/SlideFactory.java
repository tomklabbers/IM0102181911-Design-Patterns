package factory;

import interfaces.Slide;
import model.SlideModel;

public class SlideFactory {
	public static Slide createSlide() {
		return new SlideModel();
	}

}
