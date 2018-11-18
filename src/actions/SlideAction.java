package actions;

import controller.PresentationControl;

public interface SlideAction {
	public void executeAction(PresentationControl controlActions);
	public void setAction(SlideAction action);
	public SlideAction getAction();
	public ActionTypes getActionType();
	public String getActionValue();
}
