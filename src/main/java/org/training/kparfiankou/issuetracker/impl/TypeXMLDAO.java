package org.training.kparfiankou.issuetracker.impl;

import java.io.IOException;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.impl.xmlhandlers.TypeXMLHandler;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author parf
 *
 */
public class TypeXMLDAO extends AbstractXMLDAO implements ITypeDAO{
	
	private TypeXMLHandler handler;
	private String TYPE_XML_FILE_NAME = "types.xml";
	private List<Type> types; 

	public TypeXMLDAO(){
		try {
			
			String realPath = getXmlDirectoryPath() + TYPE_XML_FILE_NAME;
			
			XMLReader reader = XMLReaderFactory.createXMLReader();
			handler = new TypeXMLHandler();
			
			reader.setContentHandler(handler);
			reader.parse(realPath);
			
			types = handler.getTypes();
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Type> getListType() {
		return types;
	}

	@Override
	public Type getType(int id) {
		
		for(Type type: types){
			if (type.getId() ==  id){
				return type;
			}
		}
		
		return null; // think here and there
	}

}