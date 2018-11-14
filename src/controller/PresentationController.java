package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import accessor.PresentationReader;
import factory.PresentationFactory;
import factory.PresentationReaderFactory;
import view.PresentationView;
import interfaces.*;

public class PresentationController {
	private PresentationView view;
	
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
	
	public void setModel(Presentation model) {
		this.model = model;
	}
	
	public void open(String path) {
		PresentationReader reader = PresentationReaderFactory.createReader(path);
		model = PresentationFactory.createPresentation(reader);
		
		initView();
		
		// TODO remove debug
		model.debug();
	}
	
	public void open() {
		model = PresentationFactory.createPresentation();
		
		initView();
		
		model.debug();
	}
	
	private void initView() {
		// TODO check if view is set, else quit program
		
		view.setTitle(model.getTitle());
	}
	
	public void nextSlide() {
		model.nextSlide();
	}
	
	public void prevSlide() {
		model.prevSlide();
	}
	
	public void goToSlide(int index) {
		model.goToSlide(index);
	}
	
	public void clickAction(int x, int y) {
		// Handle this
	}
}
