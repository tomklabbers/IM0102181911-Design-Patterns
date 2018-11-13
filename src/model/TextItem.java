package model;

import interfaces.SlideItem;
import styles.SlideItemStyle;

public class TextItem implements SlideItem{
	private int level = 0;
	private String value;
	private String type = "text";
	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public SlideItemStyle getStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
		
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
		
	}

}
