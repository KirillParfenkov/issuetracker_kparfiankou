package org.training.kparfiankou.issuetracker.impl.xmlhandlers;

import java.util.ArrayList;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Type;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Kiryl_Parfiankou
 *
 */
public class TypeXMLHandler extends DefaultHandler {

	private static final String  KEY_TYPE = "type";
	private static final int  ID = 0;
	private static final int  NAME = 1;

	private List<Type> types;

	/**
	 * default Constructor.
	 */
	public TypeXMLHandler() {
		types = new ArrayList<Type>();
	}

	/**
	 *
	 * @return List\<Type\>
	 */
	public List<Type> getTypes() {
		return types;
	}

	@Override
	public void startElement(String uri, String localName,
							  String qName, Attributes attrs) throws SAXException {

		if (KEY_TYPE.equals(localName)) {
			types.add(new Type(Integer.valueOf(attrs.getValue(ID)),
						   attrs.getValue(NAME)));
		}
	}
}