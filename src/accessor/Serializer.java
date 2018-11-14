package accessor;

import java.io.InputStream;
import java.io.PrintWriter;

import interfaces.Presentation;

public interface Serializer {
	public void serialize(PrintWriter out, Presentation presentation);
	
	public void unserialize(InputStream in, Presentation presentation);
}
