package accessor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import factory.SlideFactory;
import interfaces.Presentation;
import interfaces.Slide;

public class XMLSerializer implements Serializer{
	
	/** Default API to use. */
    protected static final String DEFAULT_API_TO_USE = "dom";
    
    /** namen van xml tags of attributen */
    protected static final String SHOWTITLE = "showtitle";
    protected static final String SLIDETITLE = "title";
    protected static final String SLIDE = "slide";
    protected static final String ITEM = "item";
    protected static final String LEVEL = "level";
    protected static final String KIND = "kind";
    protected static final String TEXT = "text";
    protected static final String IMAGE = "image";
    
    private Element dom;
    
    private String getElementContent(Element element, String tagName) {
    		NodeList nodes = element.getElementsByTagName(tagName);
    		return nodes.item(0).getTextContent();
    }

	@Override
	public String serialize(Presentation p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Presentation unserialize(InputStream serializedText, Presentation presentation) {
		int slideIndex;
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
			
			// Create a DOM object to query for elements
			dom = builder.parse(serializedText).getDocumentElement();
			
			presentation.setTitle(getElementContent(dom, SHOWTITLE));

			NodeList slides = dom.getElementsByTagName(SLIDE);
			
			// Loop trough all slide elements
			for (slideIndex = 0; slideIndex < slides.getLength(); slideIndex++) {
				Element slideEl = (Element) slides.item(slideIndex);
				
				Slide slide = SlideFactory.createSlide();
				slide.setTitle(getTitle(xmlSlide, SLIDETITLE));
				presentation.append(slide);
				
				NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
				maxItems = slideItems.getLength();
				for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
					Element item = (Element) slideItems.item(itemNumber);
					loadSlideItem(slide, item);
				}
			}
		} 
		catch (IOException iox) {
			System.err.println(iox.toString());
		}
		catch (SAXException sax) {
			System.err.println(sax.getMessage());
		}
		catch (ParserConfigurationException pcx) {
			System.err.println(PCE);
		}
	}

}
