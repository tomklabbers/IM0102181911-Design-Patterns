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
			result.width = scale(result.width);
			result.height = scale(result.height);
			
			switch(item.getStyle().getAlignment()) {
				case RIGHT:
					result.x = location.width - result.width;
					break;
				case CENTER:
					result.x += ((location.width - result.width)/2);
					break;
				case LEFT:
				default:
					//no changes, default behavior
			}
			getCanvas().drawImage(value.getImage(),result.x, result.y, result.width, result.height, observer);
			return result;
		}
		else {
			return null;
		}
	}

}
