package accessor;

import java.io.InputStream;

import interfaces.Presentation;

public interface Serializer {
	public String serialize(Presentation presentation);
	
	public void unserialize(InputStream serializedText, Presentation presentation);
}
