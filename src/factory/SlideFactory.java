package factory;

import interfaces.Slide;
import model.SlideModel;

/**
 * SlideFactory creates slide
 *
 */
public class SlideFactory {
	public static Slide createSlide() {
		return new SlideModel();
	}

}
