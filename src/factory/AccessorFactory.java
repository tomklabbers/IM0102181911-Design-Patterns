package factory;

import accessor.LocalFileReader;
import accessor.LocalFileWriter;
import accessor.DemoReader;
import accessor.DemoWriter;
import accessor.FileReader;
import accessor.FileWriter;
import accessor.PresentationReader;
import accessor.PresentationWriter;
import accessor.Serializer;
import accessor.XMLSerializer;

public class AccessorFactory {
	
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
	
	public static PresentationWriter createWriter(String path) {
		if(path != null && !path.isEmpty() ) {
			FileWriter writer = new LocalFileWriter();
			Serializer serializer = getSerializer(path);

			writer.setPath(path);
			writer.setSerializer(serializer);
			
			return writer;
		}
		else {
			return new DemoWriter();
		}
	}
	
	private static Serializer getSerializer(String path) {
		// Determine serializer variant
		switch(getFileExtension(path)) {
			case "xml":
				return new XMLSerializer();
			default:
				// TODO throw exception!
				return null;
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
