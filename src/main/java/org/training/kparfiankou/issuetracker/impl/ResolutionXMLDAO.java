package org.training.kparfiankou.issuetracker.impl;

import java.io.IOException;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.impl.xmlhandlers.ResolutionXMLHandler;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author parf
 *
 */
public class ResolutionXMLDAO extends AbstractXMLDAO implements IResolutionDAO {

	private static final String TYPE_XML_FILE_NAME = "resolutions.xml";
	private ResolutionXMLHandler handler;
	private List<Resolution> resolutions;

	public ResolutionXMLDAO() {
		try {

			String realPath = getXmlDirectoryPath() + TYPE_XML_FILE_NAME;

			XMLReader reader = XMLReaderFactory.createXMLReader();
			handler = new ResolutionXMLHandler();

			reader.setContentHandler(handler);
			reader.parse(realPath);

			resolutions = handler.getResolutions();

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Resolution> getListResolution() {
		return resolutions;
	}

	public Resolution getResolution(int id) {

		for (Resolution resolution: resolutions) {
			if (resolution.getId() ==  id) {
				return resolution;
			}
		}

		return null; // think here and there.
	}	
}