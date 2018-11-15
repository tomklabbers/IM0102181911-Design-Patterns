package styles;

public class ImageItemStyle extends SlideItemStyle {
	
	public ImageItemStyle(int lvl) {
		super(lvl);
	}	
	
	@Override
	public int getIndent() {
		// TODO Auto-generated method stub
		return getLevel() * 21;
	}

}
