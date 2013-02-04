package org.training.kparfiankou.issuetracker.impl.xml;

import java.io.IOException;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.impl.xml.handlers.TypeXMLHandler;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author parf
 *
 */
public class TypeXMLDAO extends AbstractXMLDAO implements ITypeDAO {

	private static final String TYPE_XML_FILE_NAME = "types.xml";
	private TypeXMLHandler handler;
	private List<Type> types;

	/**
	 * Default constructor.
	 */
	public TypeXMLDAO() {
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
	public Type getType(long id) {

		for (Type type: types) {
			if (type.getId() ==  id) {
				return type;
			}
		}

		return null; // think here and there
	}

	@Override
	public Type getType(String nameType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeType(long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertType(Type type) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateType(Type type) {
		// TODO Auto-generated method stub
	}

	@Override
	public long getMaxIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
}