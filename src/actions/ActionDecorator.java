package actions;

import controller.PresentationControl;

public abstract class ActionDecorator implements SlideAction {
	private SlideAction nextAction = null;
	
	public SlideAction getNextAction() {
		return nextAction;
	}
	
	protected abstract void doExecuteAction(PresentationControl controlActions);
	
	/**
	 * Execute the current action and check and execute the next action
	 */	
	public final void executeAction(PresentationControl controlActions) {
		doExecuteAction(controlActions);
		if (nextAction != null) {
			nextAction.executeAction(controlActions);
		}
	}
	
	/**
	 * Set the next action 
	 */
	@Override
	public void setAction(SlideAction action) {
		nextAction = action;		
	}	
	
	@Override
	public SlideAction getAction() {
		return  nextAction;		
	}	
	
	@Override
	public String getActionValue() {
		return "";
	}
}
