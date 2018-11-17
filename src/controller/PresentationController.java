package controller;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import accessor.AccessorFactory;
import accessor.PresentationReader;
import accessor.PresentationWriter;
import actions.SlideAction;
import view.PresentationView;
import model.Presentation;
import model.PresentationFactory;

public class PresentationController implements PresentationControlActions{
	private PresentationView view;
	private SlideController slideController;
	
	private Presentation model;
	
	public PresentationController() {}
	
	public void setView(PresentationView view) {
		this.view = view;
		this.view.setupWindow();	
		
		this.view.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.view.setVisible(true);
	}
	
	private void updateView() {
		slideController.updateView();
	}
	
	public Frame getView() {
		return view;
	}
	
	public void setModel(Presentation presentation) {
		model = presentation;
		slideController.setModel(presentation);
		
		view.setTitle(model.getTitle());
		updateView();
	}
	
	public void open(String path) {
		PresentationReader reader = AccessorFactory.createReader(path);
		
		setModel(PresentationFactory.createPresentation(reader));
		
		// Show file path in title 
		if( path != null && !path.isEmpty() ) {
			view.setTitle(view.getTitle() + " - " + path);
		}
	}
	
	public void open() {
		setModel(PresentationFactory.createPresentation());
	}
	
	public void setSlideController(SlideController slideCtrl) {
		slideController = slideCtrl;
		view.getContentPane().add(slideController.getView());
	}
	
	public void save(String path) {
		PresentationWriter writer = AccessorFactory.createWriter(path);
		writer.save(model);
	}
	
	public void debug() {
		PresentationWriter writer = AccessorFactory.createWriter(null);
		writer.save(model);
	}
	
	public void nextSlide() {
		if(model.nextSlide()) {
			updateView();
		}
	}
	
	public void prevSlide() {
		if(model.prevSlide()) {
			updateView();
		}
	}
	
	public void goToSlide(int index) {
		// User input has an offset of 1
		index--;
		
		if(model.goToSlide(index)) {
			updateView();
		}
	}
	
	public void clickAction(int x, int y) {
		SlideAction item = slideController.getView().getItemAtPos(x, y);
		if (item != null) {
			item.executeAction(this);
		}		
	}
}
