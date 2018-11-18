package slideitem;

class MenuItem extends SlideItem implements SlideItemTextValue, SlideItemMenuItemValue {
	
	private int currentIndex;
	private int maxIndex;
	
	public MenuItem() {		
		this.currentIndex = 0;
		this.maxIndex = 0;
	}
	
	@Override
	public void setIndexes(int currentIndex, int maxIndex) {
		this.currentIndex = currentIndex;
		this.maxIndex = maxIndex;
	}

	@Override
	public SlideItemTypes getType() {
		return SlideItemTypes.ITEM_MENU;
	}

	@Override
	public String getValue() {
		return "Slide "+currentIndex+" of "+maxIndex;
	}
	
	@Override
	public String toString() {
		return "MenuItem[" + getStyle() + "," + getValue() + "]";
	}
}
