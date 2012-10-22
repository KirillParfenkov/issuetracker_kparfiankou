package org.training.kparfiankou.issuetracker.impl.xmlhandlers;

import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Kiryl_Parfiankou
 *
 */
public class ResolutionXMLHandler extends DefaultHandler {

	private static final String KEY_RESOLUTION = "resolution";
	private static final int  ID = 0;
	private static final int  NAME = 1;

	private List<Resolution> resolutions;

	/**
	 * Default constructor.
	 */
	public ResolutionXMLHandler() {
		resolutions = new ArrayList<Resolution>();
	}

	/**
	 *
	 * @return List\<Resolution\>
	 */
	public List<Resolution> getResolutions() {
		return resolutions;
	}

	@Override
	public void startElement(String uri, String localName,
							  String qName, Attributes attrs) throws SAXException {

		if (KEY_RESOLUTION.equals(localName)) {
			resolutions.add(new Resolution(Integer.valueOf(attrs.getValue(ID)),
						   attrs.getValue(NAME)));
		}

	}
}