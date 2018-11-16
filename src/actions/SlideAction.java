package actions;

import interfaces.PresentationControlActions;

public interface SlideAction {
	public void executeAction(PresentationControlActions controlActions);
	public void setAction(SlideAction action);
}
