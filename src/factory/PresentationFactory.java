package factory;



import model.PresentationModel;
import interfaces.Presentation;
import interfaces.Reader;

public class PresentationFactory {
	
	public static Presentation createPresentation() {
		return new PresentationModel();
	}
	
	public static Presentation createPresentation(Reader reader) {
		reader.load();
		Presentation p = new PresentationModel();
		p.setTitle(reader.getTitle());
		return p;
	}
}
