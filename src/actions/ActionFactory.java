package actions;

public class ActionFactory {
	public static SlideAction createAction(String type, String value) {
		switch (ActionTypes.getActionType(type)) {
		case ACTION_SOUND:
			return new SystemBeepAction();
		default:
			return null;
		}
	}
}
