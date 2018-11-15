import view.PresentationView;
import view.SlideView;
import controller.KeyController;
import controller.MenuController;
import controller.MouseController;
import controller.PresentationController;

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

	/** Het Main Programma */
	public static void main(String argv[]) {
		String presentationPath;
		PresentationController mainWindowCtrl;
		PresentationView mainView;
		MenuController menuCtrl; 
		
		mainWindowCtrl 	= new PresentationController();
		menuCtrl 		= new MenuController(mainWindowCtrl);
		mainView 		= new PresentationView();
		
		
		// temporarily add mousecontroller to mainView. This should
		// be added to the slide view.
		mainView.addMouseListener(new MouseController(mainWindowCtrl));
		mainView.addKeyListener(new KeyController(mainWindowCtrl));
		mainView.setMenuBar(menuCtrl);
		
		mainWindowCtrl.setView(mainView);;
		
		if (argv.length > 0) { 
			presentationPath = argv[0];
		}
		else {
			presentationPath = ""; // Demo Presentation will be loaded
		}
		
		mainWindowCtrl.open(presentationPath);
	}
}
