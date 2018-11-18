package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {
	
	PresentationControl controller;
	
	public MouseController(PresentationController ctrl) {
		controller = ctrl;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	    controller.clickAction(e.getX(), e.getY());
	}
}
