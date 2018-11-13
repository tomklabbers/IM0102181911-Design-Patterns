package accessor;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Vector;

import interfaces.Presentation;
import interfaces.Slide;

public class LocalFileReader extends FileReader {
	
	public Vector<Slide> getSlides(){
		return null;
	}
	
	public String getTitle() {
		return "LocalFileReader";
	}
	
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