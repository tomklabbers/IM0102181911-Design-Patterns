package actions;

import interfaces.PresentationControlActions;

public class PreviousSlideAction extends ActionDecorator {

	@Override
	public void doExecuteAction(PresentationControlActions controlActions) {
		controlActions.prevSlide();
	}

}
