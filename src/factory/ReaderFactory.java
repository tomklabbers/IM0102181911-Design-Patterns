package factory;



import accessor.LocalFileReader;
import accessor.DemoReader;
import accessor.FileReader;
import accessor.PresentationReader;
import accessor.Serializer;
import accessor.XMLSerializer;

public class ReaderFactory {
	
	public static PresentationReader createReader(String path) {
		if(path != null && !path.isEmpty() ) {
			FileReader reader = new LocalFileReader();
			Serializer serializer = new XMLSerializer();
			reader.setPath(path);
			reader.setSerializer(serializer);
			return reader;
		}
		else {
			return new DemoReader();
		}
	}

}
