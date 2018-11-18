package view;

import java.awt.Dimension;

import javax.swing.JFrame;

public abstract class PresentationView extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public abstract Dimension getDefaultSize();
	public abstract void updateView();
}
