package slideitem;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import java.io.IOException;

/** <p>De klasse voor een Bitmap item</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

class BitmapItem extends SlideItem implements SlideItemImageValue {
  private BufferedImage bufferedImage;
  private String imageName;
  
  protected static final String FILE = "Bestand ";
  protected static final String NOFILE = "No file specified";  
  protected static final String NOTFOUND = " niet gevonden";

	public BitmapItem() {
		imageName = NOFILE;
	}
	
	/**
	 * set name of image file
	 */
	@Override
	public void setValue(String value) {
		super.setValue(value);
		imageName = value;
		try {
			bufferedImage = ImageIO.read(new File(imageName));
		}
		catch (IOException e) {
			System.err.println(FILE + imageName + NOTFOUND) ;
		}
		
	}
	
	@Override
		public SlideItemTypes getType() {
			return SlideItemTypes.ITEM_IMAGE;
		}
	
	@Override
	public String toString() {
		return "BitmapItem[" + getStyle() + "," + imageName + "]";
	}
	
	/** Returns loaded image
	 * @return buffered image
	 */
	@Override
	public Image getImage() {
		return bufferedImage;
	}
}
