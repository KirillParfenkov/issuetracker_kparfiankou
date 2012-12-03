package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Comment;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.IssueDAOFactory;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ProjectDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ResolutionDAOFactory;
import org.training.kparfiankou.issuetracker.factories.StatusDAOFactory;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

/**
 * Servlet implementation class CreateUpdateIssueController.
 */
public class CreateUpdateIssueController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUpdateIssueController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();
		IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();
		ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
		IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
		IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
		IUserDAO userDAO = UserDAOFactory.getClassFromFactory();
		IResolutionDAO resolutionDAO = ResolutionDAOFactory.getClassFromFactory();

		List<Status> statuses = statusDAO.getListStatus();
		List<Type> types =  typeDAO.getListType();
		List<Priority> prioritys = priorityDAO.getListPriority();
		List<Project> projects = projectDAO.getListProject();
		List<User> users = userDAO.getListUser();
		List<Resolution> resolutions = resolutionDAO.getListResolution();
		int issueId = Integer.valueOf(request.getParameter(Constants.KEY_ISSUE_ID));
		List<Comment> comments = issueDAO.getCommentList(issueId);
		Issue issue = issueDAO.getIssue(issueId);

		request.setAttribute(Constants.STATUSES, statuses);
		request.setAttribute(Constants.TYPES, types);
		request.setAttribute(Constants.PRIORITYS, prioritys);
		request.setAttribute(Constants.PROJECTS, projects);
		request.setAttribute(Constants.USERS, users);
		request.setAttribute(Constants.KEY_ISSUE, issue);
		request.setAttribute(Constants.RESOLUTIONS, resolutions);
		request.setAttribute(Constants.KEY_COMMENTS, comments);

		jump(Constants.UPDATE_ISSUE_PAGE, request, response);
	}
}