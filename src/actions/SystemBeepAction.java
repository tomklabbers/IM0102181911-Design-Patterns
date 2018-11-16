package actions;

import java.awt.Toolkit;

import interfaces.PresentationControlActions;

public class SystemBeepAction extends ActionDecorator {

	@Override
	public void executeAction(PresentationControlActions controlActions) {
		Toolkit.getDefaultToolkit().beep();	
	}

}
