package actions;

import interfaces.PresentationControlActions;

public class GoToSlideAction extends ActionDecorator {
	private int slideNumber;
	
	public GoToSlideAction(int slideNumber) {
		this.slideNumber = slideNumber;
	}
	
	@Override
	public void doExecuteAction(PresentationControlActions controlActions) {
		System.out.println("go to "+slideNumber);
		controlActions.goToSlide(slideNumber);	
	}

}
