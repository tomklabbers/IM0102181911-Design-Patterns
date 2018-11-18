package view;

import javax.swing.JComponent;

import actions.SlideAction;
import model.Slide;

/**
 * Slide view to display slide items.
 */
public abstract class SlideView extends JComponent {
	private static final long serialVersionUID = 1L;
	
	public abstract void setSlide(Slide slide);
	public abstract void clear();
	public abstract SlideAction getItemAtPos(int x, int y);
}
