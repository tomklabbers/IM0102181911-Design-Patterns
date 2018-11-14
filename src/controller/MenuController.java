package controller;
import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import accessor.PresentationReader;
import factory.PresentationReaderFactory;
import interfaces.Presentation;


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
	
	private PresentationController controller;
	
	private static final long serialVersionUID = 227L;
	
	protected static final String ABOUT = "About";
	protected static final String FILE = "File";
	protected static final String EXIT = "Exit";
	protected static final String GOTO = "Go to";
	protected static final String HELP = "Help";
	protected static final String NEW = "New";
	protected static final String NEXT = "Next";
	protected static final String OPEN = "Open";
	protected static final String PAGENR = "Page number?";
	protected static final String PREV = "Prev";
	protected static final String SAVE = "Save";
	protected static final String VIEW = "View";
	
	protected static final String TESTFILE = "test.xml";
	protected static final String SAVEFILE = "dump.xml";
	
	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";
	protected static final String SAVEERR = "Save Error";

	public MenuController(PresentationController ctrl) {
		controller = ctrl;
				
		MenuItem menuItem;
		
		// ==== File Menu ====
		Menu fileMenu = new Menu(FILE);
		
		fileMenu.add(menuItem = mkMenuItem(OPEN));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("File :: Open");
				controller.open(TESTFILE);
			}
		} );
		
		fileMenu.add(menuItem = mkMenuItem(NEW));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("File :: NEW");
				controller.open();
			}
		});
		
		fileMenu.add(menuItem = mkMenuItem(SAVE));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("File :: Save");
//				Accessor xmlAccessor = new XMLAccessor();
//				try {
//					xmlAccessor.saveFile(presentation, SAVEFILE);
//				} catch (IOException exc) {
//					JOptionPane.showMessageDialog(parent, IOEX + exc, 
//							SAVEERR, JOptionPane.ERROR_MESSAGE);
//				}
			}
		});
		
		fileMenu.addSeparator();
		
		fileMenu.add(menuItem = mkMenuItem(EXIT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("Program :: Exit");
				System.exit(0);
			}
		});
		add(fileMenu);
		
		// ==== View Menu ====
		Menu viewMenu = new Menu(VIEW);
		
		viewMenu.add(menuItem = mkMenuItem(NEXT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("View :: Next");
				controller.nextSlide();
			}
		});
		
		viewMenu.add(menuItem = mkMenuItem(PREV));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("View :: Prev");
				controller.prevSlide();
			}
		});
		
		viewMenu.add(menuItem = mkMenuItem(GOTO));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String pageNumberStr = JOptionPane.showInputDialog((Object)PAGENR);
				int pageNumber = Integer.parseInt(pageNumberStr);
				System.out.println("Goto Slide :: "+pageNumber);
				controller.goToSlide(pageNumber - 1);
			}
		});
		
		add(viewMenu);
		
		// ==== Help Menu ====
		Menu helpMenu = new Menu(HELP);
		
		helpMenu.add(menuItem = mkMenuItem(ABOUT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				//AboutBox.show(parent);
			}
		});
		setHelpMenu(helpMenu);// nodig for portability (Motif, etc.).
	}

	// een menu-item aanmaken
	public MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
