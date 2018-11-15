package styles;

public abstract class SlideItemStyle {
	private int level;
	
	/**
	 * abstract <b>SlideItemStyle</b> creator
	 * @param lvl should be used to determine indentation of item 
	 */
	public SlideItemStyle(int lvl) {
		this.level = lvl;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getIndent() {
		return level * 20;
	}
	
}
