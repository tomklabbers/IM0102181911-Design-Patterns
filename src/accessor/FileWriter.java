package accessor;

/**
 * FileWriter allows to write to a file. Needs a Serializer to write the data
 *
 */
public abstract class FileWriter implements PresentationWriter, Accessor {
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
