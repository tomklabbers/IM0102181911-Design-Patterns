package accessor;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import actions.ActionFactory;
import actions.ActionTypes;
import actions.SlideAction;
import model.Presentation;
import model.Slide;
import model.SlideFactory;
import slideitem.SlideItem;
import slideitem.SlideItemFactory;
import slideitem.SlideItemImageValue;
import slideitem.SlideItemTextValue;
import styles.StyleFactory;

/**
 * XMLSerializer allows to read or write a presentation from or to a XML source
 *
 */
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
    protected static final String ACTION = "action";
    protected static final String VALUE = "value"; 
    protected static final String NAME = "name";
    
    private Element dom;
    
    /**
     * Retrieve content of XML element by tagname
     * @param element
     * @param tagName
     * @return content of element
     */
    private String getElementContent(Element element, String tagName) {
    		NodeList nodes = element.getElementsByTagName(tagName);
    		return nodes.item(0).getTextContent();
    }
    
    /**
     * Retrieve a numeric value of an attribute 
     * @param nnm node map
     * @param attrName Name of attribute
     * @return integer value of attribute
     */
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

    /**
     * Retrieve a text value of an attribute
     * @param nnm node map
     * @param attrName Name of attribute
     * @return text value of attribute
     */    
    private String getTextAttr(NamedNodeMap nnm, String attrName) {
		return nnm.getNamedItem(attrName).getTextContent();
    }

    /**
     * Unserialize an inputstream to a presentation
     */
	@Override
	public void unserialize(InputStream in, Presentation presentation) {
		int slideIndex, itemIndex;
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
			
			// Create a DOM object to query for elements
			dom = builder.parse(in).getDocumentElement();
			
			presentation.setTitle(getElementContent(dom, SHOWTITLE));

			NodeList slides = dom.getElementsByTagName(SLIDE);
			
			// Loop trough all slide elements
			for (slideIndex = 0; slideIndex < slides.getLength(); slideIndex++) {
				Element slideEl = (Element) slides.item(slideIndex);
				
				Slide slide = SlideFactory.createSlide();
				slide.setTitle(getElementContent(slideEl, SLIDETITLE));
				
				NodeList slideItems = slideEl.getElementsByTagName("*");
				SlideAction  prevAction = null;
				for (itemIndex = 0; itemIndex < slideItems.getLength(); itemIndex++) {
					Element itemEl = (Element) slideItems.item(itemIndex);
					
					// Retrieve SlideItem attributes
					NamedNodeMap attributes = itemEl.getAttributes();

					if (itemEl.getNodeName().equals(ACTION)) {
						String name = getTextAttr(attributes, NAME);
						String value = "";
						if (attributes.getNamedItem(VALUE) != null) {
							value = getTextAttr(attributes, VALUE);
						}
						SlideAction action = ActionFactory.createAction(name, value);
						action.setAction(prevAction);
						prevAction = action;
					}
					else if (itemEl.getNodeName().equals(ITEM)){
						int level 	= getNumberAttr(attributes, LEVEL);
						String type 	= getTextAttr(attributes, KIND);
						SlideItem item = SlideItemFactory.createSlideItem(type);
						// Only continue populating SlideItem if type is supported
						if(item != null) {
							if(prevAction != null) {
								item.setAction(prevAction);
							}							
							item.setStyle(StyleFactory.createStyle(item.getType(), prevAction != null, level));							
							item.setValue(itemEl.getTextContent());
							
							// Add SlideItem to the parent Slide
							slide.addItem(item);
						}
						else {
							System.err.println("Invalid SlideItem in XML file with type: "+type);
						}	
						prevAction = null;
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
	
	/**
	 * Write the item to a xml element
	 * @param out PrintWrite
	 * @param slideItem The slide item to write
	 */
	private void serializeItem(PrintWriter out, SlideItem slideItem) {
		out.print("<item kind="); 
		if (slideItem instanceof SlideItemTextValue) {
			out.print("\"text\" level=\"" + slideItem.getStyle().getLevel() + "\">");
			out.print(slideItem.getRawValue());
		}
		else if (slideItem instanceof SlideItemImageValue) {
			out.print("\"image\" level=\"" + slideItem.getStyle().getLevel() + "\">");
			out.print(slideItem.getRawValue());
		}
		else {
			System.out.println("Ignoring " + slideItem);
		}
//		
		out.println("</item>");		
	}
	
	/**
	 * Serialize the presentation content to a PrintWriter
	 */
	@Override
	public void serialize(PrintWriter out, Presentation p) {
		out.println("<?xml version=\"1.0\"?>");
		out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
		out.println("<presentation>");
		out.print("<showtitle>");
		out.print(p.getTitle());
		out.println("</showtitle>");
		
		Vector<Slide> slides = p.getSlides();
		
		for (int slideIndex=0; slideIndex < slides.size(); slideIndex++) {
			
			Slide slide = slides.get(slideIndex);
			out.println("<slide>");
			out.println("<title>" + slide.getTitle() + "</title>");
			
			// Get the SlideItems without temporarily items.
			Vector<SlideItem> slideItems = slide.getRawItems();
			
			for (int itemIndex = 0; itemIndex < slideItems.size(); itemIndex++) {
				SlideItem slideItem = (SlideItem) slideItems.elementAt(itemIndex);
				SlideAction action = slideItem.getAction();
				while (action != null) {
					out.println(String.format("<action name=\"%s\" value=\"%s\">", 
							ActionTypes.getActionName(action.getActionType()),
							action.getActionValue()));				
					action = action.getAction();
				}
				serializeItem(out, slideItem);
				action = slideItem.getAction();				
				while (action != null) {
					out.println("</action>");
					action = action.getAction();
				}
				
			}
			out.println("</slide>");
		}
		out.println("</presentation>");
	}

}
