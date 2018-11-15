package accessor;

import factory.SlideFactory;
import factory.SlideItemFactory;
import interfaces.Presentation;
import interfaces.Slide;
import model.SlideItem;

public class DemoReader implements PresentationReader {
	
	/**
	 * This method loads a demo presentation which is hardcoded.
	 */
	public void load(Presentation presentation) {
		SlideItem item;
		Slide slide;
		
		presentation.setTitle("DEMO Presentatie JabberPoint");
		
		slide = SlideFactory.createSlide();
		slide.setTitle("JabberPoint");
		
		item = SlideItemFactory.createSlideItem("text", 1);
		item.setValue("Het Java Presentatie Tool");
		slide.addItem(item);
		
		item = SlideItemFactory.createSlideItem("text", 2);
		item.setValue("Copyright (c) 1996-2000: Ian Darwin");
		slide.addItem(item);
		
		item = SlideItemFactory.createSlideItem("image", 2);
		item.setValue("serclogo_fc.jpg");
		slide.addItem(item);		

		item = SlideItemFactory.createSlideItem("text", 2);
		item.setValue("Copyright (c) 2000-now:");
		slide.addItem(item);

		item = SlideItemFactory.createSlideItem("text", 2);
		item.setValue("Gert Florijn en Sylvia Stuurman");
		slide.addItem(item);

		item = SlideItemFactory.createSlideItem("text", 4);
		item.setValue("JabberPoint aanroepen zonder bestandsnaam");
		slide.addItem(item);

		item = SlideItemFactory.createSlideItem("text", 4);
		item.setValue("laat deze presentatie zien");
		slide.addItem(item);

		item = SlideItemFactory.createSlideItem("text", 1);
		item.setValue("Navigeren:");
		slide.addItem(item);

		item = SlideItemFactory.createSlideItem("text", 3);
		item.setValue("Volgende slide: PgDn of Enter");
		slide.addItem(item);

		item = SlideItemFactory.createSlideItem("text", 3);
		item.setValue("Vorige slide: PgUp of up-arrow");
		slide.addItem(item);

		item = SlideItemFactory.createSlideItem("text", 3);
		item.setValue("Stoppen: q or Q");
		slide.addItem(item);

		presentation.addSlide(slide);

		slide = SlideFactory.createSlide();
		slide.setTitle("Demonstratie van levels en stijlen");
		
		item = SlideItemFactory.createSlideItem("text", 1);
		item.setValue("Level 1");
		slide.addItem(item);
		
		item = SlideItemFactory.createSlideItem("text", 2);
		item.setValue("Level 2");
		slide.addItem(item);
		
		item = SlideItemFactory.createSlideItem("text", 1);
		item.setValue("Nogmaals level 1");
		slide.addItem(item);
		
		item = SlideItemFactory.createSlideItem("text", 1);
		item.setValue("Level 1 heeft stijl nummer 1");
		slide.addItem(item);
		
		item = SlideItemFactory.createSlideItem("text", 2);
		item.setValue("Level 2 heeft stijl nummer 2");
		slide.addItem(item);
		
		item = SlideItemFactory.createSlideItem("text", 3);
		item.setValue("Zo ziet level 3 er uit");
		slide.addItem(item);
		
		item = SlideItemFactory.createSlideItem("text", 4);
		item.setValue("En dit is level 4");
		slide.addItem(item);
		
		presentation.addSlide(slide);

		slide = SlideFactory.createSlide();
		slide.setTitle("De derde slide");
		
		item = SlideItemFactory.createSlideItem("text", 1);
		item.setValue("Om een nieuwe presentatie te openen,");
		slide.addItem(item);
		
		item = SlideItemFactory.createSlideItem("text", 2);
		item.setValue("gebruik File->Open uit het menu.");
		slide.addItem(item);
		
		item = SlideItemFactory.createSlideItem("text", 1);
		item.setValue(" ");
		slide.addItem(item);
		
		item = SlideItemFactory.createSlideItem("text", 1);
		item.setValue("Dit is het einde van de presentatie.");
		slide.addItem(item);
		
		item = SlideItemFactory.createSlideItem("image", 1);
		item.setValue("JabberPoint.jpg");
		slide.addItem(item);
		
		presentation.addSlide(slide);
	}

}

