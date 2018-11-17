package painter;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import slideitem.SlideItem;
import slideitem.SlideItemImageValue;

class GImagePainter extends GraphicsPainter {
	private ImageObserver observer;
	
	public GImagePainter(Graphics canvas, float scale, ImageObserver observer) {
		super(canvas, scale);
		this.observer = observer;
	}

	@Override
	public Rectangle draw(SlideItem item, Rectangle drawArea) {
		if (item != null && item instanceof SlideItemImageValue) {
			SlideItemImageValue value = (SlideItemImageValue) item;
			
			// Scale the original draw area 
			Rectangle scaledArea = new Rectangle();
			
			scaledArea.width = scale(value.getImage().getWidth(observer));
			scaledArea.height = scale(value.getImage().getHeight(observer));
			scaledArea.y = drawArea.y + scale(item.getStyle().getLeading());
			
			// Calculate the x position based on the item alignment
			// Center align  is not affected by the indent style 
			int indentation = scale(item.getStyle().getIndent());
			
			switch(item.getStyle().getAlignment()) {
				case RIGHT:
					scaledArea.x = (drawArea.width - scaledArea.width) - indentation ;
					break;
				case CENTER:
					scaledArea.x = ((drawArea.width - scaledArea.width)/2);
					break;
				case LEFT:
				default:
					scaledArea.x = drawArea.x + indentation;
			}
			
			getCanvas().drawImage(value.getImage(), scaledArea.x, scaledArea.y, scaledArea.width, scaledArea.height, observer);
			
			return scaledArea;
		}
		else {
			return drawArea;
		}
	}
}
