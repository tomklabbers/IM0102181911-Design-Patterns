package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		this.view.setTitle(this.model.getTitle());
		this.model.debug();
	}
}
