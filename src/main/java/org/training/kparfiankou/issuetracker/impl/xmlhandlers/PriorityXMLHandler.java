package org.training.kparfiankou.issuetracker.impl.xmlhandlers;

import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PriorityXMLHandler extends DefaultHandler {

	private static final String KEY_PRIORITY = "priority";
	private static final int ID = 0;
	private static final int NAME = 1;

	private List<Priority> prioritys;

	public PriorityXMLHandler() {
		prioritys = new ArrayList<Priority>();
	}

	public List<Priority> getPrioritys() {
		return prioritys;
	}

	public void startElement(String uri, String localName,
							 String qName,Attributes attrs) throws SAXException {

		if (KEY_PRIORITY.equals(localName)) {
			prioritys.add(new Priority(Integer.valueOf(attrs.getValue(ID)),
								attrs.getValue(NAME)));
		}
	}
}