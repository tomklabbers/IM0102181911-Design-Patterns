package actions;

import controller.PresentationControlActions;

/**
 * Action that allows to open a specified presentation
 *
 */

public class OpenPresentationAction extends ActionDecorator {
	private String path;
	
	public OpenPresentationAction(String path) {
		this.path = path;
	}
	
	@Override
	public void doExecuteAction(PresentationControlActions controlActions) {
		controlActions.open(path);
	}

	@Override
	public ActionTypes getActionType() {
		return ActionTypes.ACTION_OPEN_PRESENTATION;
	}
	
	@Override
	public String getActionValue() {
		return path;
	}	
}
