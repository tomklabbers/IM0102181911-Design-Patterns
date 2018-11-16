package actions;

public abstract class ActionDecorator implements SlideAction {
	private SlideAction nextAction = null;
	
	public SlideAction getNextAction() {
		return nextAction;
	}
	@Override
	public void setAction(SlideAction action) {
		nextAction = action;		
	}	
}
