package actions;

import interfaces.PresentationControlActions;

/**
 * Action that allows to go to the previous slide of the current presentation
 *
 */
public class PreviousSlideAction extends ActionDecorator {

	@Override
	public void doExecuteAction(PresentationControlActions controlActions) {
		controlActions.prevSlide();
	}

	@Override
	public ActionTypes getActionType() {
		return ActionTypes.ACTION_PREV_PRESENTATION;
	}
	
}
