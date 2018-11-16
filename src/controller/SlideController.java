package controller;

import interfaces.Presentation;
import interfaces.Slide;
import view.SlideView;

public class SlideController {
	
	private SlideView view;
	private Presentation model;
	
	public SlideController(SlideView slideView) {
		view = slideView;
	}
	
	public void setModel(Presentation presentation) {
		model = presentation;
	}
	
	public SlideView getView() {
		return view;
	}
	
	public void updateView() {
		Slide slide = model.getCurrentSlide();
		view.setSlide(slide);
	}
}
