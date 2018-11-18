package actions;

import java.awt.Toolkit;

import controller.PresentationControl;

/**
 * Action that beeps on execution
 *
 */

class SystemBeepAction extends ActionDecorator {

	@Override
	public void doExecuteAction(PresentationControl controlActions) {
		Toolkit.getDefaultToolkit().beep();	
	}
	
	@Override
	public ActionTypes getActionType() {
		return ActionTypes.ACTION_SOUND;
	}
	
}
