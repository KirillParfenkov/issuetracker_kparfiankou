package org.training.kparfiankou.issuetracker.impl;

import java.io.IOException;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.impl.xmlhandlers.StatusXMLHandler;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author parf
 *
 */
public class StatusXMLDAO extends AbstractXMLDAO implements IStatusDAO {

	private static final String TYPE_XML_FILE_NAME = "statuses.xml";
	private StatusXMLHandler handler;
	private List<Status> statuses;

	/**
	 * Default constructor.
	 */
	public StatusXMLDAO() {
		try {

			String realPath = getXmlDirectoryPath() + TYPE_XML_FILE_NAME;

			XMLReader reader = XMLReaderFactory.createXMLReader();
			handler = new StatusXMLHandler();

			reader.setContentHandler(handler);
			reader.parse(realPath);

			statuses = handler.getStatuses();

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Status> getListStatus() {
		return statuses;
	}

	@Override
	public Status getStatus(int id) {

		for (Status status: statuses) {
			if (status.getId() ==  id) {
				return status;
			}
		}

		return null; // think here and there.
	}
}