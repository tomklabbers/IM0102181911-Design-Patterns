package actions;

public class ActionFactory {
	
	
	public static SlideAction createAction(String type, String value) {
		switch (ActionTypes.getActionType(type)) {
		case ACTION_SOUND:
			return new SystemBeepAction();
		case ACTION_OPEN_PRESENTATION:
			return new OpenPresentationAction(value);
		case ACTION_NEXT_PRESENTATION:
			return new NextSlideAction();
		case ACTION_PREV_PRESENTATION:
			return new PreviousSlideAction();
		case ACTION_GOTO_PRESENTATION:
			return new GoToSlideAction(Integer.parseInt(value));		
		default:
			return null;
		}
	}
}
