package view;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

public class PresentationView  extends JFrame {
	private static final long serialVersionUID = 3227L;
	
	private static final String JABTITLE = "Jabberpoint 1.6 - OU";
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	
	public PresentationView() {
		super();
	}
	
	public void setupWindow() {
		setTitle(JABTITLE);
		setSize(new Dimension(WIDTH, HEIGHT)); // Dezelfde maten als Slide hanteert.
//		
		//getContentPane().add(slideViewerComponent);
		//addKeyListener(new KeyController(presentation)); // een controller toevoegen
		//setMenuBar(new MenuController(this, presentation));	// nog een controller toevoegen
		
	}
}
