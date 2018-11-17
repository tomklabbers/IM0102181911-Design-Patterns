package actions;

import interfaces.PresentationControlActions;

/**
 * Action that allows to go to a specified slide number within the current Presentation
 *
 */
public class GoToSlideAction extends ActionDecorator {
	private int slideNumber;
	
	public GoToSlideAction(int slideNumber) {
		this.slideNumber = slideNumber;
	}
	
	@Override
	public void doExecuteAction(PresentationControlActions controlActions) {
		controlActions.goToSlide(slideNumber);	
	}
	
	@Override
	public ActionTypes getActionType() {
		return ActionTypes.ACTION_GOTO_PRESENTATION;
	}

	@Override
	public String getActionValue() {
		return Integer.toString(slideNumber);
	}
}
