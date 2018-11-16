package actions;

import interfaces.PresentationControlActions;

public class PreviousSlideAction extends ActionDecorator {

	@Override
	public void executeAction(PresentationControlActions controlActions) {
		controlActions.prevSlide();
	}

}
