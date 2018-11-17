package actions;

import interfaces.PresentationControlActions;

public class GoToSlideAction extends ActionDecorator {
	private int slideNumber;
	
	public GoToSlideAction(int slideNumber) {
		this.slideNumber = slideNumber;
	}
	
	@Override
	public void doExecuteAction(PresentationControlActions controlActions) {
		controlActions.goToSlide(slideNumber);		
	}

}
