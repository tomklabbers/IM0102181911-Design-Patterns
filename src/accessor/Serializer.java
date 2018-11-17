package accessor;

import java.io.InputStream;
import java.io.PrintWriter;

import interfaces.Presentation;

/**
 * Serializer interface used to fill or read a presentation from a source
 */
public interface Serializer {
	public void serialize(PrintWriter out, Presentation presentation);
	
	public void unserialize(InputStream in, Presentation presentation);
}
