package actions;

import java.awt.Toolkit;
import interfaces.PresentationControlActions;

/**
 * Action that beeps on execution
 *
 */

class SystemBeepAction extends ActionDecorator {

	@Override
	public void doExecuteAction(PresentationControlActions controlActions) {
		Toolkit.getDefaultToolkit().beep();	
	}
	
	@Override
	public ActionTypes getActionType() {
		return ActionTypes.ACTION_SOUND;
	}
	
}
