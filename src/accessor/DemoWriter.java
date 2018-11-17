package accessor;

import java.util.Vector;

import interfaces.Presentation;
import interfaces.Slide;
import slideitem.SlideItem;

public class DemoWriter implements PresentationWriter {

	@Override
	public void save(Presentation presentation) {
		System.out.println("Presentation: "+presentation.getTitle());
		Vector<Slide> slides = presentation.getSlides();
		System.out.println("Num of Slides: "+slides.size());
		int i, j; Slide s; SlideItem item;
		for(i = 0; i<slides.size(); i++) {
			s = slides.get(i);
			Vector<SlideItem> items = s.getItems();
			System.out.println("- Slide: "+s.getTitle()+" items: "+items.size());
			
			for(j = 0; j<items.size(); j++) {
				item = items.get(j);
				System.out.println("-- Item: "+item.getType()+" level: "+item.getStyle().getLevel()+" value: "+item.getRawValue());
			}
		}
	}

}
