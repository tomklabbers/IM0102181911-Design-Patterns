package painter;

import javafx.geometry.BoundingBox;
import model.SlideItem;

public interface SlidePainter {
	public BoundingBox draw(SlideItem item, BoundingBox area);
}
