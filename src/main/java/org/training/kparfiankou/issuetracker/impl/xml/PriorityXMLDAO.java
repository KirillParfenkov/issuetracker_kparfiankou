package org.training.kparfiankou.issuetracker.impl.xml;

import java.io.IOException;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.impl.xml.handlers.PriorityXMLHandler;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author parf
 *
 */
public class PriorityXMLDAO extends AbstractXMLDAO implements IPriorityDAO {

	private static final String TYPE_XML_FILE_NAME = "prioritys.xml";
	private PriorityXMLHandler handler;
	private List<Priority> prioritys;

	/**
	 * Default constructor.
	 */
	public PriorityXMLDAO() {
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

	@Override
	public List<Priority> getListPriority() {
		return prioritys;
	}

	@Override
	public Priority getPriority(int id) {

		for (Priority priority: prioritys) {
			if (priority.getId() ==  id) {
				return priority;
			}
		}

		return null; // think here and there
	}

	@Override
	public Priority getPriority(String namePriority) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
	}

	@Override
	public void removePriority(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertPriority(Priority priority) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updatePriority(Priority priority) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getMaxIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
}