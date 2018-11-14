package accessor;

public interface Accessor {
	
	public void setPath(String p);
	
	public String getPath();
	
	public void setSerializer(Serializer s);
	
	public Serializer getSerializer();

}
