/**
 * 
 */
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
 * @author theparf
 *
 */
public class TypeXMLDAO implements ITypeDAO{
	
	private TypeXMLHandler handler;
	private String TYPE_XML_FILE_NAME = "classes/dataXML/types.xml";
	private List<Type> types; 

	public TypeXMLDAO(){
		try {
		
			XMLReader reader = XMLReaderFactory.createXMLReader();
			handler = new TypeXMLHandler();
			
			reader.setContentHandler(handler);
			reader.parse(TYPE_XML_FILE_NAME);
			
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
		
		return null; // think here
	}

}
