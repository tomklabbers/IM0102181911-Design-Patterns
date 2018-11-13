package accessor;

public abstract class FileReader implements PresentationReader {
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
