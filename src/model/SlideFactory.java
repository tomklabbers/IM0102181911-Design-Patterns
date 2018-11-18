package model;

/**
 * SlideFactory creates slide model
 *
 */
public class SlideFactory {
	
	/**
	 * Creates a simple slide model. No variations yet.
	 * 
	 * @return Slide
	 */
	public static Slide createSlide() {
		return new SlideModel();
	}
}
