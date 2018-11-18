package controller;

import java.awt.Frame;

import accessor.AccessorFactory;
import accessor.PresentationReader;
import accessor.PresentationWriter;
import actions.SlideAction;
import view.PresentationView;
import model.Presentation;
import model.PresentationFactory;

public class PresentationController implements PresentationControl{
	private PresentationView view;
	private SlideControl slideController;
	
	private Presentation model;
	
	@Override
	public void setView(PresentationView view) {
		this.view = view;
		this.view.updateView();	
		this.view.setVisible(true);
	}
	
	@Override
	public Frame getView() {
		return view;
	}
	
	@Override
	public void setModel(Presentation presentation) {
		model = presentation;
		
		view.setTitle(model.getTitle());
		updateView();
	}
	
	@Override
	public void openPresentation(String path) {
		PresentationReader reader = AccessorFactory.createReader(path);
		
		setModel(PresentationFactory.createPresentation(reader));
		
		// Show file path in title 
		if( path != null && !path.isEmpty() ) {
			view.setTitle(view.getTitle() + " - " + path);
		}
	}
	
	@Override
	public void newPresentation() {
		setModel(PresentationFactory.createPresentation());
	}
	
	@Override
	public void setSlideController(SlideControl slideCtrl) {
		slideController = slideCtrl;
		view.getContentPane().add(slideController.getView());
	}
	
	@Override
	public void savePresentation(String path) {
		PresentationWriter writer = AccessorFactory.createWriter(path);
		writer.save(model);
	}
	
	@Override
	public void nextSlide() {
		if(model.nextSlide()) {
			updateView();
		}
	}
	
	@Override
	public void prevSlide() {
		if(model.prevSlide()) {
			updateView();
		}
	}
	
	@Override
	public void goToSlide(int index) {
		// User input has an offset of 1
		index--;
		
		if(model.goToSlide(index)) {
			updateView();
		}
	}
	
	@Override
	public void clickAction(int x, int y) {
		SlideAction item = slideController.getView().getItemAtPos(x, y);
		if (item != null) {
			// Pass the current controller instance to the action.
			// The action uses this controller to change the presentation state
			item.executeAction(this);
		}		
	}
	
	/**
	 * Notify the slide controller that the state of
	 * the model is changed.
	 */
	private void updateView() {
		slideController.updateView(model);
	}
}
