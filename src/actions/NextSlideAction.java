package actions;

import interfaces.PresentationControlActions;

/**
 * Action that allows to go to the next slide of the current Presentation
 *
 */
public class NextSlideAction extends ActionDecorator {

	@Override
	public void doExecuteAction(PresentationControlActions controlActions) {
		controlActions.nextSlide();
	}

	@Override
	public ActionTypes getActionType() {
		return ActionTypes.ACTION_NEXT_PRESENTATION;
	}

}
