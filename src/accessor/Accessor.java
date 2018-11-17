package accessor;

/**
 * Accessor interface used to access presentation source
 *
 */
public interface Accessor {
	
	public void setPath(String p);
	
	public String getPath();
	
	public void setSerializer(Serializer s);
	
	public Serializer getSerializer();

}
