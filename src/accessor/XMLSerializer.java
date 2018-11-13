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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import factory.SlideFactory;
import factory.SlideItemFactory;
import interfaces.Presentation;
import interfaces.Slide;
import interfaces.SlideItem;

public class XMLSerializer implements Serializer{
	
	/** Default API to use. */
    protected static final String DEFAULT_API_TO_USE = "dom";
    
    /** Names for XML elements */
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
    
    private int getNumberAttr(NamedNodeMap nnm, String attrName) {
    		String text = nnm.getNamedItem(attrName).getTextContent();
    		int num = 0;
		if (text != null) {
			try {
				num = Integer.parseInt(text);
			}
			catch(NumberFormatException x) {
				System.err.println("Number Format Exception");
			}
		}
		return num;
    }
    
    private String getTextAttr(NamedNodeMap nnm, String attrName) {
		return nnm.getNamedItem(attrName).getTextContent();
    }

	@Override
	public String serialize(Presentation p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unserialize(InputStream serializedText, Presentation presentation) {
		int slideIndex, itemIndex;
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
				slide.setTitle(getElementContent(slideEl, SLIDETITLE));
				
				NodeList slideItems = slideEl.getElementsByTagName(ITEM);
				for (itemIndex = 0; itemIndex < slideItems.getLength(); itemIndex++) {
					Element itemEl = (Element) slideItems.item(itemIndex);
					
					// Retrieve SlideItem attributes
					NamedNodeMap attributes = itemEl.getAttributes();
					int level 	= getNumberAttr(attributes, LEVEL);
					String type 	= getTextAttr(attributes, KIND);
					
					SlideItem item = SlideItemFactory.createSlideItem(type, level);
					
					// Only continue populating SlideItem if type is supported
					if(item != null) {
						item.setValue(itemEl.getTextContent());
						
						// Add SlideItem to the parent Slide
						slide.addItem(item);
					}
					else {
						System.err.println("Invalid SlideItem in XML file with type: "+type);
					}
				}
				
				presentation.addSlide(slide);
			}
		} 
		catch (IOException iox) {
			System.err.println(iox.toString());
		}
		catch (SAXException sax) {
			System.err.println(sax.getMessage());
		}
		catch (ParserConfigurationException pcx) {
			System.err.println("Parser Configuration Exception");
		}
	}

}
