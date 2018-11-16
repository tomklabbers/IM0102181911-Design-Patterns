package actions;

import interfaces.PresentationControlActions;

public class NextSlideAction extends ActionDecorator {

	@Override
	public void executeAction(PresentationControlActions controlActions) {
		controlActions.nextSlide();
	}

}
