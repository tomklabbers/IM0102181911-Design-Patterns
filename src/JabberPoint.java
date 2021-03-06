import view.PresentationViewFrame;
import view.SlideViewComponent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controller.KeyController;
import controller.MenuController;
import controller.MouseController;
import controller.PresentationController;
import controller.SlideController;

/** JabberPoint Main Programma
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class JabberPoint {
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

	/**
	 * Initialize Jabberpoint. 
	 * 
	 * This method creates the views and controllers
	 * for the Jabberpoint application.
	 * 
	 * @param argv
	 */
	public static void main(String argv[]) {
		String presentationPath;
		PresentationController mainWindowCtrl;
		SlideController slideCtrl;
		SlideViewComponent slideView;
		PresentationViewFrame mainView;
		MenuController menuCtrl; 
		
		mainWindowCtrl 	= new PresentationController();
		menuCtrl 		= new MenuController(mainWindowCtrl);
		mainView 		= new PresentationViewFrame();
		slideView 		= new SlideViewComponent(mainView);
		slideCtrl 		= new SlideController(slideView);
		
		slideView.addMouseListener(new MouseController(mainWindowCtrl));
		
		mainView.addKeyListener(new KeyController(mainWindowCtrl));
		mainView.setMenuBar(menuCtrl);
		mainView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		if (argv.length > 0) { 
			// Path to presentation file to load
			presentationPath = argv[0];
		}
		else {
			// If no path is given a demo will be loaded
			presentationPath = null;
		}
		
		// Setup presentation controller and open presentation on start up.
		mainWindowCtrl.setView(mainView);
		mainWindowCtrl.setSlideController(slideCtrl);
		mainWindowCtrl.openPresentation(presentationPath);
	}
}
