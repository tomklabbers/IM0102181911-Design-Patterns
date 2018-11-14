package accessor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import interfaces.Presentation;

public class LocalFileWriter extends accessor.FileWriter {
	
	public void save(Presentation p) {
		Serializer serializer = getSerializer();
		PrintWriter out;
		
		try {
			out = new PrintWriter(new FileWriter(getPath()));
		} catch (IOException e) {
			// TODO Handle exception
			e.printStackTrace();
			
			return;
		}
			
		serializer.serialize(out, p);
		
		out.close();	
	}

}
