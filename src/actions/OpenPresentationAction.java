package actions;

import interfaces.PresentationControlActions;

public class OpenPresentationAction extends ActionDecorator {
	private String path;
	
	public OpenPresentationAction(String path) {
		this.path = path;
	}
	
	@Override
	public void executeAction(PresentationControlActions controlActions) {
		controlActions.open(path);
	}

}
