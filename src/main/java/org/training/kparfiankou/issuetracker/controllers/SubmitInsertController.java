package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Build;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.IssueDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;

/**
 * Servlet implementation class SubmitInsertController
 */
public class SubmitInsertController extends AbstractController {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitInsertController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		jump(Constants.MAIN_CONTROLLER , request, response);

		HttpSession session = request.getSession();
		IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();
		Issue issue = new Issue(issueDAO.getListIssue().size()); //Temporary solution.

		String summary = (String) session.getAttribute(Constants.KEY_SUMMARY);
		String description = (String) session.getAttribute(Constants.KEY_DESCRIPTION);
		Status status = (Status) session.getAttribute(Constants.KEY_STATUS);
		Type type = (Type) session.getAttribute(Constants.KEY_TYPE);
		Priority priority = (Priority) session.getAttribute(Constants.KEY_PRIORITY);
		Project project = (Project) session.getAttribute(Constants.KEY_PROJECT);
		Build build = (Build) session.getAttribute(Constants.KEY_BUILD);
		User assignee = (User) session.getAttribute(Constants.KEY_ASSIGNEE);

		issue.setSummary(summary); System.out.println(summary);
		issue.setDescription(description); System.out.println(description);
		issue.setStatus(status); System.out.println(status);
		issue.setType(type); System.out.println(type);
		issue.setPriority(priority); System.out.println(priority);
		issue.setProject(project); System.out.println(project);
		issue.setBuild(build); System.out.println(build);
		issue.setAssignee(assignee);System.out.println(assignee);

		issueDAO.insertIssue(issue);
	}
}