package actions;

public enum ActionTypes {
	ACTION_UNKNOWN,
	ACTION_SOUND,
	ACTION_OPEN_PRESENTATION;
	
	public static ActionTypes getActionType(String name) {
		switch (name) {
		case "beep":
			return ACTION_SOUND;
		case "presentation":
			return ACTION_OPEN_PRESENTATION;
		default:
			return ACTION_UNKNOWN;
		}
	}
	
	public static String getActionName(ActionTypes type) {
		switch (type) {
		case ACTION_SOUND:
			return "beep";
		case ACTION_OPEN_PRESENTATION:
			return "presentation";
		default:
			return "unknown";
		}
	}
}
