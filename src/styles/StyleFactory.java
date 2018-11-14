package styles;

public class StyleFactory {
	public static SlideItemStyle createStyle(String slideItemType, boolean hasActions, int level) {
		switch(slideItemType) {
		case "text":
			if (hasActions) {
				return new TextItemActionStyle(level);
			}
			else {
				return new TextItemStyle(level);
			}
		case "image":
			if (hasActions) {
				return new ImageItemActionStyle(level);
			}
			else {
				return new ImageItemStyle(level);
			}
		default:
			return null;
		}
	}
}
