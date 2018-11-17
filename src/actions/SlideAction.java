package actions;

import controller.PresentationControlActions;

public interface SlideAction {
	public void executeAction(PresentationControlActions controlActions);
	public void setAction(SlideAction action);
	public SlideAction getAction();
	public ActionTypes getActionType();
	public String getActionValue();
}
