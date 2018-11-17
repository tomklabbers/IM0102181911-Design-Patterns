package accessor;

import actions.ActionFactory;
import actions.SlideAction;
import factory.SlideFactory;
import interfaces.Presentation;
import interfaces.Slide;
import slideitem.SlideItem;
import slideitem.SlideItemFactory;
import styles.StyleFactory;

public class DemoReader implements PresentationReader {
	
	private SlideItem createDemoItem(String type, int level, String value) {
		SlideItem item = SlideItemFactory.createSlideItem(type);
		if (item != null) {
			item.setValue(value);
			item.setStyle(StyleFactory.createStyle(item.getType(), false, level));
		}
		return item;
	}
	
	private SlideItem createActionedDemoItem(String type, int level, String value, SlideAction action) {
		SlideItem item = SlideItemFactory.createSlideItem(type);
		if (item != null) {
			item.setValue(value);
			item.setStyle(StyleFactory.createStyle(item.getType(), action != null, level));
			item.setAction(action);
		}
		return item;
	}	
	
	/**
	 * This method loads a demo presentation which is hardcoded.
	 */
	public void load(Presentation presentation) {
		Slide slide;
		
		presentation.setTitle("DEMO Presentatie JabberPoint");
		
		slide = SlideFactory.createSlide();
		slide.setTitle("JabberPoint");
		
		slide.addItem(createDemoItem("text", 1, "Het Java Presentatie Tool"));		
		slide.addItem(createDemoItem("text", 2,"Copyright (c) 1996-2000: Ian Darwin"));
		slide.addItem(createDemoItem("image", 2,"serclogo_fc.jpg"));			
		slide.addItem(createDemoItem("text", 2,"Copyright (c) 2000-now:"));
		slide.addItem(createDemoItem("text", 2,"Gert Florijn en Sylvia Stuurman"));
		slide.addItem(createDemoItem("text", 4,"JabberPoint aanroepen zonder bestandsnaam"));
		slide.addItem(createDemoItem("text", 4,"laat deze presentatie zien"));
		slide.addItem(createDemoItem("text", 1,"Navigeren:"));
		
		SlideAction action = ActionFactory.createAction("next", "");
		slide.addItem(createActionedDemoItem("text", 3,"Volgende slide: PgDn of Enter", action));
		
		slide.addItem(createDemoItem("text", 3,"Vorige slide: PgUp of up-arrow"));
		slide.addItem(createDemoItem("text", 3,"Stoppen: q or Q"));

		presentation.addSlide(slide);

		slide = SlideFactory.createSlide();
		slide.setTitle("Demonstratie van levels en stijlen");
		
		slide.addItem(createDemoItem("text", 1,"Level 1"));		
		slide.addItem(createDemoItem("text", 2,"Level 2"));
		slide.addItem(createDemoItem("text", 1,"Nogmaals level 1"));
		slide.addItem(createDemoItem("text", 1,"Level 1 heeft stijl nummer 1"));
		slide.addItem(createDemoItem("text", 2,"Level 2 heeft stijl nummer 2"));
		slide.addItem(createDemoItem("text", 3,"Zo ziet level 3 er uit"));
		slide.addItem(createDemoItem("text", 4,"En dit is level 4"));

		presentation.addSlide(slide);

		slide = SlideFactory.createSlide();
		slide.setTitle("De derde slide");
		
		slide.addItem(createDemoItem("text", 1,"Om een nieuwe presentatie te openen,"));	
		slide.addItem(createDemoItem("text", 2,"gebruik File->Open uit het menu."));		
		slide.addItem(createDemoItem("text", 1," "));		
		slide.addItem(createDemoItem("text", 1,"Dit is het einde van de presentatie."));		
		slide.addItem(createDemoItem("image", 1,"JabberPoint.jpg"));
		
		presentation.addSlide(slide);
	}

}

