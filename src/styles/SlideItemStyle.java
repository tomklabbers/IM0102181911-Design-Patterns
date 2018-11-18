package styles;

/**
 * Default style for all items.
 */
public abstract class SlideItemStyle {
	private int level;
	
	private Alignment alignment;
	private int leading;
	
	public static enum Alignment {RIGHT, LEFT, CENTER};
	
	/**
	 * abstract <b>SlideItemStyle</b> creator
	 * @param lvl should be used to determine indentation of item 
	 */
	public SlideItemStyle(int lvl) {
		level = lvl;
		alignment = Alignment.LEFT;
		
		switch(level) {
			case 0:
				leading = 20;
				break;
			default:
				leading = 10;
		}
	}
	
	public void setLeading(int leading) {
		this.leading = leading;
	}
	
	public int getLeading() {
		return leading;
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
		if (getLevel() == 0) {
			return 0;
		}
		else if (getLevel() == 1) {
			return 20;
		}
		else {
			return (getLevel() * 20) + 10;
		}
	}
	
}
