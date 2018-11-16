package view;
import java.awt.Dimension;
import javax.swing.JFrame;

public class PresentationView  extends JFrame {
	private static final long serialVersionUID = 3227L;
	
	private static final String JABTITLE = "Jabberpoint Assignment Christiaan Visser & Tom Klabbers";
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	
	public PresentationView() {
		super();
	}
	
	public void setupWindow() {
		setTitle(JABTITLE);
		setSize(getDefaultSize());
	}
	
	public Dimension getDefaultSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
}
