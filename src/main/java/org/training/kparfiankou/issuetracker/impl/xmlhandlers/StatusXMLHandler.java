package org.training.kparfiankou.issuetracker.impl.xmlhandlers;

import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Status;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class StatusXMLHandler extends DefaultHandler{
	
	private static final String KEY_STATUS = "status";
	private static final int ID = 0;
	private static final int NAME = 1;
	
	private List<Status> statuses;
	
	public StatusXMLHandler(){
		statuses = new ArrayList<Status>();
	}
	
	public List<Status> getStatuses(){
		return statuses;
	}
	
	public void startElement(String uri, String localName,
							 String qName,Attributes attrs) throws SAXException {
		
		if (KEY_STATUS.equals(localName)){
			statuses.add(new Status(Integer.valueOf(attrs.getValue(ID)),
								attrs.getValue(NAME)));
		}
	
	}
}
