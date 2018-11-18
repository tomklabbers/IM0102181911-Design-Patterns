package controller;

import model.Presentation;
import model.Slide;
import view.SlideView;

public class SlideController implements SlideControl {
	private SlideView view;
	private Presentation model;
	
	public SlideController(SlideView slideView) {
		view = slideView;
	}
	
	@Override
	public void setModel(Presentation presentation) {
		model = presentation;
	}
	
	@Override
	public SlideView getView() {
		return view;
	}
	
	@Override
	public void updateView() {
		Slide slide = model.getCurrentSlide();
		
		if(slide != null) {
			slide.setMenu(model.getCurrentSlideNumber(), model.getSlideCount());
			view.setSlide(slide);
		}
		else {
			view.clear();
		}
	}
}
