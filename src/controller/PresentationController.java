package controller;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import accessor.PresentationReader;
import accessor.PresentationWriter;
import factory.PresentationFactory;
import factory.AccessorFactory;
import view.PresentationView;
import view.SlideView;
import interfaces.*;

public class PresentationController {
	private PresentationView view;
	private SlideView slideView;
	
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
		setSlideView(new SlideView(this.view));
	}
	
	private void initView() {
		// TODO check if view is set, else quit program
		
		view.setTitle(model.getTitle());
		slideView.setSlide(model.getCurrentSlide());
	}
	
	public Frame getView() {
		return view;
	}
	
	public void setModel(Presentation model) {
		this.model = model;
	}
	
	public void setSlideView(SlideView slideComponent) {
		this.slideView = slideComponent;
		this.view.getContentPane().add(slideComponent);
	}
	
	public void open(String path) {
		PresentationReader reader = AccessorFactory.createReader(path);
		model = PresentationFactory.createPresentation(reader);
		
		initView();
	}
	
	public void open() {
		model = PresentationFactory.createPresentation();
		
		initView();
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
