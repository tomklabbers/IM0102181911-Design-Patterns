package actions;

import interfaces.PresentationControlActions;

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

}
