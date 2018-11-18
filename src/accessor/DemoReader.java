package accessor;

import actions.ActionFactory;
import actions.ActionTypes;
import actions.SlideAction;
import model.Presentation;
import model.Slide;
import model.SlideFactory;
import slideitem.SlideItem;
import slideitem.SlideItemFactory;
import slideitem.SlideItemTypes;
import styles.StyleFactory;

/**
 * DemoReader class creates a hard coded demo presentation
 *
 */

public class DemoReader implements PresentationReader {
	
	private SlideItem createDemoItem(SlideItemTypes type, int level, String value) {
		SlideItem item = SlideItemFactory.createSlideItem(type);
		if (item != null) {
			item.setValue(value);
			item.setStyle(StyleFactory.createStyle(item.getType(), false, level));
		}
		return item;
	}
	
	private SlideItem createActionedDemoItem(SlideItemTypes type, int level, String value, SlideAction action) {
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
		
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 1, "Het Java Presentatie Tool"));		
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 2,"Copyright (c) 1996-2000: Ian Darwin"));
		SlideAction imgActn = ActionFactory.createAction(ActionTypes.ACTION_SOUND, "");
		slide.addItem(createActionedDemoItem(SlideItemTypes.ITEM_IMAGE, 2,"serclogo_fc.jpg", imgActn));		
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 2,"Copyright (c) 2000-now:"));
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 2,"Gert Florijn en Sylvia Stuurman"));
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 4,"JabberPoint aanroepen zonder bestandsnaam"));
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 4,"laat deze presentatie zien"));
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 1,"Navigeren:"));
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 3,"Volgende slide: PgDn of Enter"));		
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 3,"Vorige slide: PgUp of up-arrow"));
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 3,"Stoppen: q or Q"));

		presentation.addSlide(slide);

		slide = SlideFactory.createSlide();
		slide.setTitle("Demonstratie van levels en stijlen");
		
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 1,"Level 1"));		
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 2,"Level 2"));
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 1,"Nogmaals level 1"));
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 1,"Level 1 heeft stijl nummer 1"));
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 2,"Level 2 heeft stijl nummer 2"));
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 3,"Zo ziet level 3 er uit"));
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 4,"En dit is level 4"));

		presentation.addSlide(slide);
		
		slide = SlideFactory.createSlide();
		slide.setTitle("Demonstratie van acties");

		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 5,"Alle items met acties krijgen een kader"));	
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 2,"Acties:"));			
		
		SlideAction nextActn = ActionFactory.createAction(ActionTypes.ACTION_NEXT_PRESENTATION, "");
		slide.addItem(createActionedDemoItem(SlideItemTypes.ITEM_TEXT, 3,"Volgende slide", nextActn));	
		SlideAction prevActn = ActionFactory.createAction(ActionTypes.ACTION_PREV_PRESENTATION, "");
		slide.addItem(createActionedDemoItem(SlideItemTypes.ITEM_TEXT, 3,"Vorige slide", prevActn));	
		SlideAction beepActn = ActionFactory.createAction(ActionTypes.ACTION_SOUND, "");
		slide.addItem(createActionedDemoItem(SlideItemTypes.ITEM_TEXT, 3,"Beep", beepActn));
		
		beepActn = ActionFactory.createAction(ActionTypes.ACTION_SOUND, "");
		beepActn.setAction(nextActn);
		slide.addItem(createActionedDemoItem(SlideItemTypes.ITEM_TEXT, 3,"Next + Beep", beepActn));
		
		SlideAction openActn = ActionFactory.createAction(ActionTypes.ACTION_OPEN_PRESENTATION, "test.xml");
		beepActn = ActionFactory.createAction(ActionTypes.ACTION_SOUND, "");
		openActn.setAction(beepActn);
		slide.addItem(createActionedDemoItem(SlideItemTypes.ITEM_TEXT, 3,"Beep + Open text.xml", openActn));
		
		SlideAction gotoActn = ActionFactory.createAction(ActionTypes.ACTION_GOTO_PRESENTATION, "1");
		slide.addItem(createActionedDemoItem(SlideItemTypes.ITEM_TEXT, 3,"Ga naar de eerste slide", gotoActn));
		openActn = ActionFactory.createAction(ActionTypes.ACTION_OPEN_PRESENTATION, "test.xml");
		slide.addItem(createActionedDemoItem(SlideItemTypes.ITEM_TEXT, 3,"Open test.xml", openActn));
		
		presentation.addSlide(slide);		
		
		slide = SlideFactory.createSlide();
		slide.setTitle("De vierde slide");
		
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 1,"Om een nieuwe presentatie te openen,"));	
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 2,"gebruik File->Open uit het menu."));		
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 1," "));		
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_TEXT, 1,"Dit is het einde van de presentatie."));		
		slide.addItem(createDemoItem(SlideItemTypes.ITEM_IMAGE, 1,"JabberPoint.jpg"));
		
		presentation.addSlide(slide);
	}

}

