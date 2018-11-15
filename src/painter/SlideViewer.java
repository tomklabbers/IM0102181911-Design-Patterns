package painter;

import java.awt.Rectangle;
import java.util.Observable;

import interfaces.Slide;
import model.SlideItem;
import styles.BorderStyle;
import view.PresentationView;

public class SlideViewer {
	private PainterFactory factory;
	
	public SlideViewer(PainterFactory factory) {
		this.factory = factory;		
	}
	public void drawSlide(Slide slide) {
		int y = 0;
		for (SlideItem item : slide.getItems()) {
			SlidePainter painter = null;
			switch (item.getType()) {
				case "text":{
					painter = factory.createTextPainter();
					break;
				}
				case "image":{
					painter = factory.createImagePainter();
					break;
				}
			}	
			if (painter == null) {
				continue;
			}
			int x = item.getLevel() * 20;
			Rectangle location = new Rectangle(x, y, PresentationView.WIDTH - x, 0); 
			BorderStyle borderStyle = null;
			if (item.getStyle() instanceof BorderStyle) {
				borderStyle = (BorderStyle)item.getStyle();
				location.x += borderStyle.getBorderStrokeWidth();
				location.width = location.width - (borderStyle.getBorderStrokeWidth() * 2);				
			}
			Rectangle result = painter.draw(item, location);
			if(borderStyle != null) {
				SlidePainter borderpainter = factory.createBorderPainter();				
				Rectangle borderLocation = new Rectangle(x,y, PresentationView.WIDTH - x, result.height + borderStyle.getBorderStrokeWidth());
				result = borderpainter.draw(item, borderLocation);
			}
			if (result != null) {
				y += result.height;
			}						
		}
	}	
	 
}
