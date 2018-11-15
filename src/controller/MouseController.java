package controller;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {
	
	PresentationController controller;
	
	public MouseController(PresentationController ctrl) {
		controller = ctrl;
	}
	
	public void mouseClicked(MouseEvent e) {
	    System.out.println("You clicked mouse at coordinates " + e.getX() + ", " + e.getY());
	    controller.clickAction(e.getX(), e.getY());
	    	Toolkit.getDefaultToolkit().beep();
	}
}
