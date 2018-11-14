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
	 * Create a normal presentation object. 
	 * 
	 * @param reader The reader object that can set the presentation data.
	 * @return Presentation The presentation object.
	 */
	public static Presentation createPresentation(PresentationReader reader) {
		Presentation p = new PresentationModel();
		
		// Use reader to populate presentation with data
		reader.load(p);
		
		return p;
	}
}
