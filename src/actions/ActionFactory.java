package actions;

public class ActionFactory {
	
	
	public static SlideAction createAction(String type, String value) {
		switch (ActionTypes.getActionType(type)) {
		case ACTION_SOUND:
			return new SystemBeepAction();
		case ACTION_OPEN_PRESENTATION:
			return new OpenPresentationAction(value);
		default:
			return null;
		}
	}
}
