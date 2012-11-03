package org.training.kparfiankou.issuetracker.impl.xml;

import java.io.IOException;
import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.impl.xml.handlers.IssueXMLHandler;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Kiryl_Parfiankou
 *
 */
public class IssueXMLDAO extends AbstractXMLDAO implements IIssueDAO {

	private static final String TYPE_XML_FILE_NAME = "issues.xml";
	private List<Issue> issues;
	private IssueXMLHandler handler;
	private String realPath;

	/**
	 * Default constructor.
	 */
	public IssueXMLDAO() {

		realPath = getXmlDirectoryPath() + TYPE_XML_FILE_NAME;
		loadData();
	}

	/**
	 * load data.
	 */
	private void loadData() {

		try {

			XMLReader reader = XMLReaderFactory.createXMLReader();
			handler = new IssueXMLHandler();

			reader.setContentHandler(handler);
			reader.parse(realPath);

			issues = handler.getIsssues();


		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Issue> getListIssue() {

		return issues;
	}

	@Override
	public Issue getIssue(int id) {

		for (Issue issue: issues) {
			if (issue.getId() == id) {
				return issue;
			}
		}

		return null; // think
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertIssue(Issue issue) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeIssue(int id) {
		// TODO Auto-generated method stub
	}
}