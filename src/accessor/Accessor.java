package accessor;

/**
 * Accessor interface is used to interact with a presentation source
 *
 */
public interface Accessor {
	/**
	 * Set the path to the presentation source.
	 * 
	 * @param p
	 */
	public void setPath(String p);
	
	public String getPath();
	
	/**
	 * Set the serializer that will be used to load or save a presentation
	 * 
	 * @param s
	 */
	public void setSerializer(Serializer s);
	
	public Serializer getSerializer();

}
