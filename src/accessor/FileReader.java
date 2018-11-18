package accessor;

/**
 * FileReader allows to access a file. Needs a Serializer to process the data
 *
 */
public abstract class FileReader implements PresentationReader, Accessor {
	private Serializer serializer;	
	private String path;
	
	public void setPath(String p) {
		path = p;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setSerializer(Serializer s) {
		serializer = s;
	}
	
	public Serializer getSerializer() {
		return serializer;
	}
}
