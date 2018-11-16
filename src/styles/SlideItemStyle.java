package styles;

public abstract class SlideItemStyle {
	private int level;
	private Alignment alignment;
	
	public static enum Alignment {RIGHT, LEFT, CENTER};
	
	/**
	 * abstract <b>SlideItemStyle</b> creator
	 * @param lvl should be used to determine indentation of item 
	 */
	public SlideItemStyle(int lvl) {
		this.level = lvl;
		alignment = Alignment.LEFT;
	}
	
	public void setAlignment(Alignment align) {
		alignment = align;
	}
	
	public Alignment getAlignment() {
		return alignment;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getIndent() {
		return level * 20;
	}
	
}
