package actions;

import interfaces.PresentationControlActions;

public abstract class ActionDecorator implements SlideAction {
	private SlideAction nextAction = null;
	
	public SlideAction getNextAction() {
		return nextAction;
	}
	
	protected abstract void doExecuteAction(PresentationControlActions controlActions);
	
	/**
	 * Execute the current action and check and execute the next action
	 */	
	public final void executeAction(PresentationControlActions controlActions) {
		doExecuteAction(controlActions);
		if (nextAction != null) {
			nextAction.executeAction(controlActions);
		}
	}
	
	/**
	 * Set the action 
	 */
	@Override
	public void setAction(SlideAction action) {
		nextAction = action;		
	}	
}
