package actions;

public enum ActionTypes {
	ACTION_UNKNOWN,
	ACTION_SOUND,
	ACTION_OPEN_PRESENTATION,
	ACTION_PREV_PRESENTATION,
	ACTION_NEXT_PRESENTATION,
	ACTION_GOTO_PRESENTATION;
	
	public static ActionTypes getActionType(String name) {
		switch (name) {
		case "beep":
			return ACTION_SOUND;
		case "presentation":
			return ACTION_OPEN_PRESENTATION;
		case "next":
			return ACTION_NEXT_PRESENTATION;
		case "previous":
			return ACTION_PREV_PRESENTATION;
		case "goto":
			return ACTION_GOTO_PRESENTATION;
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
		case ACTION_NEXT_PRESENTATION:
			return "next";
		case ACTION_PREV_PRESENTATION:
			return "previous";
		case ACTION_GOTO_PRESENTATION:
			return "goto";
		default:
			return "unknown";
		}
	}
}
