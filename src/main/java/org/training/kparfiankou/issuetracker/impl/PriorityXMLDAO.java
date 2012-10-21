package org.training.kparfiankou.issuetracker.impl;

import java.io.IOException;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.impl.xmlhandlers.PriorityXMLHandler;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author parf
 *
 */
public class PriorityXMLDAO extends AbstractXMLDAO implements IPriorityDAO{
	
	private PriorityXMLHandler handler;
	private String TYPE_XML_FILE_NAME = "prioritys.xml";
	private List<Priority> prioritys; 

	public PriorityXMLDAO(){
		try {
			
			String realPath = getXmlDirectoryPath() + TYPE_XML_FILE_NAME;
			
			XMLReader reader = XMLReaderFactory.createXMLReader();
			handler = new PriorityXMLHandler();
			
			reader.setContentHandler(handler);
			reader.parse(realPath);
			
			prioritys = handler.getPrioritys();
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public List<Priority> getListPriority() {
		return prioritys;
	}
	
	
	public Priority getPriority(int id) {
		
		for(Priority priority: prioritys){
			if (priority.getId() ==  id){
				return priority;
			}
		}
		
		return null; // think here and there
	}
}