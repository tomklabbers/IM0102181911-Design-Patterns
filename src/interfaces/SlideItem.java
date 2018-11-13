package interfaces;
import styles.SlideItemStyle;

public interface SlideItem {
	public String getValue();
	public void setValue(String value);
	public String getType();
	public SlideItemStyle getStyle();
	public int getLevel();
	public void setLevel(int level);
}
