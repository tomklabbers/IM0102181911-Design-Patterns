package accessor;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import interfaces.Presentation;

public class LocalFileReader extends FileReader {
	
	public void load(Presentation p) {
		File file = new File(getPath());
		
		if(file.exists()) {
			InputStream is = null;
			
			try {
				is = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// Should not happen because we already checked the existence of the file
			}
			
			Serializer serializer = getSerializer();
			
			serializer.unserialize(is, p);
		}		
	}

}
