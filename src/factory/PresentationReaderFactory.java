package factory;

import accessor.LocalFileReader;
import accessor.DemoReader;
import accessor.FileReader;
import accessor.PresentationReader;
import accessor.Serializer;
import accessor.XMLSerializer;

public class PresentationReaderFactory {
	
	public static PresentationReader createReader(String path) {
		if(path != null && !path.isEmpty() ) {
			FileReader reader = new LocalFileReader();
			Serializer serializer; 	
			
			// Determine serializer variant
			switch(getFileExtension(path)) {
				case "xml":
					serializer = new XMLSerializer();
					break;
				default:
					serializer = null;
			}
			
			reader.setPath(path);
			reader.setSerializer(serializer);
			
			return reader;
		}
		else {
			return new DemoReader();
		}
	}
	
	private static String getFileExtension(String path) {
		if(path != null) {
			int index = path.lastIndexOf('.');
			
			if(index > 0) {
				return path.substring(index + 1);
			}
		}
		
		// Return empty string if no extension is found.
		return "";
	}

}
