package controller;

import model.Presentation;
import view.SlideView;

public interface SlideControl {
	public SlideView getView();
	public void updateView();
	public void setModel(Presentation model);
}
