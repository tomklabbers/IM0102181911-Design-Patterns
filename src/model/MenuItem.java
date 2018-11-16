package model;

import interfaces.SlideItemTextValue;

public class MenuItem extends SlideItem implements SlideItemTextValue {
	
	private int currentIndex;
	private int maxIndex;
	
	public MenuItem(int level, int currentIndex, int maxIndex) {
		super(level);
		
		this.currentIndex = currentIndex;
		this.maxIndex = maxIndex;
	}

	@Override
	public String getType() {
		return "menu";
	}

	@Override
	public String getValue() {
		return "Slide "+currentIndex+" of "+maxIndex;
	}
}
