package actions;

import interfaces.PresentationControlActions;

public class NextSlideAction extends ActionDecorator {

	@Override
	public void doExecuteAction(PresentationControlActions controlActions) {
		controlActions.nextSlide();
	}

}
