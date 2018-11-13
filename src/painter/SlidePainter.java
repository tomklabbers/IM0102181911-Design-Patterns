package painter;

import javafx.geometry.BoundingBox;
import interfaces.SlideItem;

public interface SlidePainter {
	public BoundingBox draw(SlideItem item, BoundingBox area);
}
