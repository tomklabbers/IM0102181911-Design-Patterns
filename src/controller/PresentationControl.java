package controller;

import java.awt.Frame;

import model.Presentation;
import view.PresentationView;

/**
 * Interface for a presentation controller
 */
public interface PresentationControl {
	public void goToSlide(int index);
	public void prevSlide();
	public void nextSlide();	
	
	public void openPresentation(String path);
	public void savePresentation(String path);
	public void newPresentation();
	
	public void clickAction(int x, int y);
	public void setSlideController(SlideControl slideCtrl);
	
	public Frame getView();
	public void setModel(Presentation model);
	public void setView(PresentationView view);
}
