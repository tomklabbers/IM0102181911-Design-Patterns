package model;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;

import interfaces.SlideItemImageValue;

import java.io.IOException;


/** <p>De klasse voor een Bitmap item</p>
 * <p>Bitmap items hebben de verantwoordelijkheid om zichzelf te tekenen.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class BitmapItem extends SlideItem implements SlideItemImageValue {
  private BufferedImage bufferedImage;
  private String imageName;
  
  protected static final String FILE = "Bestand ";
  protected static final String NOTFOUND = " niet gevonden";

// level staat voor het item-level; name voor de naam van het bestand met de afbeelding
	public BitmapItem(int level) {
		super(level);
	}
	
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

// Een leeg bitmap-item
	public BitmapItem() {
		this(0);
	}

// geef de bestandsnaam van de afbeelding
	public String getName() {
		return imageName;
	}
	
	@Override
		public String getType() {
			return "image";
		}

// geef de bounding box van de afbeelding
//	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
//		return new Rectangle((int) (myStyle.indent * scale), 0,
//				(int) (bufferedImage.getWidth(observer) * scale),
//				((int) (myStyle.leading * scale)) + 
//				(int) (bufferedImage.getHeight(observer) * scale));
//	}
//
//// teken de afbeelding
//	public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
//		int width = x + (int) (myStyle.indent * scale);
//		int height = y + (int) (myStyle.leading * scale);
//		g.drawImage(bufferedImage, width, height,(int) (bufferedImage.getWidth(observer)*scale),
//                (int) (bufferedImage.getHeight(observer)*scale), observer);
//	}

	public String toString() {
		return "BitmapItem[" + getLevel() + "," + imageName + "]";
	}
	
	@Override
	public Image getImage() {
		return bufferedImage;
	}
}
