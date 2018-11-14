package factory;

import model.PresentationModel;
import accessor.PresentationReader;
import interfaces.Presentation;

/**
 * PresentationFactory
 * 
 * The PresentationFactory is responsible for the creation
 * of Presentation objects. 
 *
 */
public class PresentationFactory {
	/**
	 * createPresentation
	 * 
	 * Create an empty presentation
	 * 
	 * @return Presentation the presentation object.
	 */
	public static Presentation createPresentation() {
		Presentation p = new PresentationModel();
		
		return p;
	}
	
	/**
	 * createPresentation
	 * 
	 * Create a normal presentation object using a reader to populate 
	 * the presentation data.
	 *  
	 * @param reader The reader object that can set the presentation data.
	 * @return Presentation The presentation object.
	 */
	public static Presentation createPresentation(PresentationReader reader) {
		Presentation p = createPresentation();
		
		// Use reader to populate presentation with data
		reader.load(p);
		
		return p;
	}
}
