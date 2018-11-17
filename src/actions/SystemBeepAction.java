package actions;

import java.awt.Toolkit;

import interfaces.PresentationControlActions;

class SystemBeepAction extends ActionDecorator {

	@Override
	public void doExecuteAction(PresentationControlActions controlActions) {
		Toolkit.getDefaultToolkit().beep();	
	}

}
