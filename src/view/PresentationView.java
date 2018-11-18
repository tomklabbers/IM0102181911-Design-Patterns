package view;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Presentation view to create a window for the presentation.
 */
public abstract class PresentationView extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public abstract Dimension getDefaultSize();
	public abstract void updateView();
}
