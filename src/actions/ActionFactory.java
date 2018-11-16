package actions;

public class ActionFactory {
	public SlideAction createAction(String type, String value) {
		switch (type) {
		case "sound":
			return new SystemBeepAction();

		default:
			return null;
		}
	}
}
