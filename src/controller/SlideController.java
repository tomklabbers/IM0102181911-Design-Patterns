package controller;

import model.Presentation;
import model.Slide;
import view.SlideView;

public class SlideController implements SlideControl {
	private SlideView view;
	
	public SlideController(SlideView slideView) {
		view = slideView;
	}
	
	@Override
	public SlideView getView() {
		return view;
	}
	
	@Override
	public void updateView(Presentation model) {
		Slide slide = model.getCurrentSlide();
		
		if(slide != null) {
			// The slide menu in the top right corner is also added as slide item.
			slide.setMenu(model.getCurrentSlideNumber(), model.getSlideCount());
			
			// Tell the view to draw this slide.
			view.setSlide(slide);
		}
		else {
			// No slides in this model. Clear the view.
			view.clear();
		}
	}
}
