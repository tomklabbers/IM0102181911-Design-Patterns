package slideitem;

import actions.SlideAction;
import interfaces.PresentationControlActions;
import styles.SlideItemStyle;

/** <p>De abstracte klasse voor een item op een Slide<p>
 * <p>Alle SlideItems hebben tekenfunctionaliteit.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public abstract class SlideItem implements SlideAction{
	private SlideItemStyle style;
	private String value;
	private SlideAction action = null;
	
	public abstract SlideItemTypes getType();
	
	public SlideItemStyle getStyle() {
		return this.style;
	}
	
	public void setStyle(SlideItemStyle style) {
		this.style = style;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getRawValue() {
		return value;
	}
	
	@Override
	public void executeAction(PresentationControlActions controlActions) {
		if (action != null) {
			action.executeAction(controlActions);
		}
	}
	
	@Override
	public void setAction(SlideAction action) {
		this.action = action;		
	}
}
