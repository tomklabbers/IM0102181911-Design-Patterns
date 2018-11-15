package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;

public class SlideView extends JComponent {
	
	private static final long serialVersionUID = 1L;
	
	private Frame parentView;
	
	public SlideView(Frame parent) {
		parentView = parent;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(parentView.getWidth(), parentView.getHeight());
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(getSize().width/4, getSize().height/4, getSize().width/2, getSize().height/2);
//		if (presentation.getSlideNumber() < 0 || slide == null) {
//			return;
//		}
//		g.setFont(labelFont);
//		g.setColor(COLOR);
//		g.drawString("Slide " + (1 + presentation.getSlideNumber()) + " of " +
//                 presentation.getSize(), XPOS, YPOS);
//		Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
//		slide.draw(g, area, this);
	}
}
