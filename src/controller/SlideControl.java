package controller;

import model.Presentation;
import view.SlideView;

/**
 * Interface for a slide controller
 */
public interface SlideControl {
	public SlideView getView();
	public void updateView(Presentation model);
}
