package painter;

public interface PainterFactory {	
	public SlidePainter createTextPainter();
	public SlidePainter createImagePainter();	
	public SlidePainter createBorderPainter();

}