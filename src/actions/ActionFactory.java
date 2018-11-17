package actions;

public class ActionFactory {
	
	/**
	 * Create an action by the specified type	
	 * @param type Action type
	 * @param value optional action value
	 * @return Action
	 */
	public static SlideAction createAction(ActionTypes type, String value) {
		switch (type) {
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
	
	/**
	 * Create an action by the specified type	
	 * @param name Name of action type
	 * @param value optional action value
	 * @return Action
	 */	
	public static SlideAction createAction(String name, String value) {
		return createAction(ActionTypes.getActionType(name), value);
	}
	
}
