package accessor;

public class AccessorFactory {
	/**
	 * Create a presentation reader to load a presentation
	 * @param path
	 * @return
	 */
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
			// No input path was given, load the demo presentation
			return new DemoReader();
		}
	}
	
	/**
	 * Create a presentation writer to save a presentation.
	 * 
	 * @param path
	 * @return
	 */
	public static PresentationWriter createWriter(String path) {
		if(path != null && !path.isEmpty() ) {
			FileWriter writer = new LocalFileWriter();
			Serializer serializer = getSerializer(path);

			writer.setPath(path);
			writer.setSerializer(serializer);
			
			return writer;
		}
		else {
			// No output path was given, use the demo writer
			return new DemoWriter();
		}
	}
	
	/**
	 * Use the given path to determine the serializer. The file
	 * extension is used to load the serializer instance.
	 * 
	 * @param path
	 * 
	 * @return
	 */
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
