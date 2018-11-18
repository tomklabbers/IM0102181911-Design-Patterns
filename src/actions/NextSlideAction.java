package actions;

import controller.PresentationControl;

/**
 * Action that allows to go to the next slide of the current Presentation
 *
 */
public class NextSlideAction extends ActionDecorator {

	@Override
	public void doExecuteAction(PresentationControl controlActions) {
		controlActions.nextSlide();
	}

	@Override
	public ActionTypes getActionType() {
		return ActionTypes.ACTION_NEXT_PRESENTATION;
	}

}
