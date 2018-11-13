package factory;



import model.PresentationModel;
import accessor.PresentationReader;
import interfaces.Presentation;

public class PresentationFactory {
	
	public static Presentation createPresentation(PresentationReader reader) {
		Presentation p = new PresentationModel();
		reader.load(p);
		
		return p;
	}
}
