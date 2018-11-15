package painter;

import model.SlideItem;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.image.ImageObserver;

import interfaces.SlideItemImageValue;

class GImagePainter extends GraphicsPainter {
	private ImageObserver observer;
	public GImagePainter(Graphics canvas, float scale, ImageObserver observer) {
		super(canvas, scale);
		this.observer = observer;
	}

	@Override
	public Rectangle draw(SlideItem item, Rectangle location) {
		if (item instanceof SlideItemImageValue) {
			SlideItemImageValue value = (SlideItemImageValue) item;
			Rectangle result = new Rectangle(location.x, location.y, value.getImage().getWidth(observer) ,value.getImage().getHeight(observer));
			result.width *= getScale();
			result.height *= getScale();
			getCanvas().drawImage(value.getImage(),location.x, location.y,(int) (result.width), (int) (result.height), observer);
			return result;
		}
		else {
			return null;
		}
	}

}
