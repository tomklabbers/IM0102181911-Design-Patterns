package controller;

import java.awt.MenuBar;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.AboutView;


/** <p>De controller voor het menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
	
	private PresentationControl controller;
	final JFileChooser fc;
	
	private static final long serialVersionUID = 227L;
	
	protected static final String DEBUG = "Debug";
	protected static final String ABOUT = "About";
	protected static final String FILE = "File";
	protected static final String EXIT = "Exit";
	protected static final String GOTO = "Go to";
	protected static final String HELP = "Help";
	protected static final String NEW = "New";
	protected static final String DEMO = "Demo";
	protected static final String NEXT = "Next";
	protected static final String OPEN = "Open";
	protected static final String PAGENR = "Page number?";
	protected static final String PREV = "Prev";
	protected static final String SAVE = "Save";
	protected static final String VIEW = "View";

	public MenuController(PresentationControl ctrl) {
		controller = ctrl;
		
		fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Jabber Files", "xml", "json");
		fc.setFileFilter(filter);
				
		MenuItem menuItem;
		
		// ==== File Menu ====
		Menu fileMenu = new Menu(FILE);
		
		fileMenu.add(menuItem = mkMenuItem(OPEN));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("File :: Open");
				int returnVal = fc.showOpenDialog(controller.getView());

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();

		            controller.openPresentation(file.getPath());
		        } else {
		            System.out.println("Open command cancelled by user.");
		        }
			}
		} );
		
		fileMenu.add(menuItem = mkMenuItem(NEW));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				controller.newPresentation();
			}
		});
		
		fileMenu.add(menuItem = mkMenuItem(SAVE));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnVal = fc.showSaveDialog(controller.getView());

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();

		            controller.savePresentation(file.getPath());
		        } else {
		            System.out.println("Save command cancelled by user.");
		        }
				
			}
		});
		
		fileMenu.add(menuItem = mkMenuItem(DEMO));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open Demo presentation
				controller.openPresentation(null);
			}
		});
		
		fileMenu.addSeparator();
		
		fileMenu.add(menuItem = mkMenuItem(EXIT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.exit(0);
			}
		});
		add(fileMenu);
		
		// ==== View Menu ====
		Menu viewMenu = new Menu(VIEW);
		
		viewMenu.add(menuItem = mkMenuItem(NEXT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				controller.nextSlide();
			}
		});
		
		viewMenu.add(menuItem = mkMenuItem(PREV));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				controller.prevSlide();
			}
		});
		
		viewMenu.add(menuItem = mkMenuItem(GOTO));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String pageNumberStr = JOptionPane.showInputDialog((Object)PAGENR);
				int pageNumber = Integer.parseInt(pageNumberStr);
				controller.goToSlide(pageNumber);
			}
		});
		
		add(viewMenu);
		
		// ==== Help Menu ====
		Menu helpMenu = new Menu(HELP);
		
		helpMenu.add(menuItem = mkMenuItem(ABOUT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AboutView.show(controller.getView());
			}
		});
		
		helpMenu.add(menuItem = mkMenuItem(DEBUG));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// Activates the demo writer to print presentation to console
				controller.savePresentation(null);
			}
		});
		
		setHelpMenu(helpMenu);// nodig for portability (Motif, etc.).
	}

	// een menu-item aanmaken
	private MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
