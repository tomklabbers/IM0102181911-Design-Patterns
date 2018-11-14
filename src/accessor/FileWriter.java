package accessor;

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
