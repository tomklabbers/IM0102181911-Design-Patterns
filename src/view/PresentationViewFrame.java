package view;
import java.awt.Dimension;

public class PresentationViewFrame extends PresentationView {
	private static final long serialVersionUID = 3227L;
	private static final String JABTITLE = "Jabberpoint Assignment Christiaan Visser & Tom Klabbers";
	
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	
	public PresentationViewFrame() {
		super();
	}
	
	@Override
	public void updateView() {
		setTitle(JABTITLE);
		setSize(getDefaultSize());
	}
	
	@Override
	public Dimension getDefaultSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
}
