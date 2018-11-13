package factory;



import interfaces.Reader;
import model.DemoReader;

public class ReaderFactory {
	
	public static Reader createReader(String path) {
		if(path != null && !path.isEmpty() ) {
			return new DemoReader();
		}
		else {
			return new DemoReader();
		}
	}

}
