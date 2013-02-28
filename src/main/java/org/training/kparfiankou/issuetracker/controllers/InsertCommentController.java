package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Comment;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.IssueDAOFactory;
import org.training.kparfiankou.issuetracker.dao.IIssueDAO;

/**
 * AbstractController implementation class InsertCommentController.
 */
public class InsertCommentController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCommentController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();

		long maxCommetnId = issueDAO.getMaxCommetnId();
		long issueId = Long.valueOf(request.getParameter(Constants.KEY_ISSUE_ID));
		String content = request.getParameter(Constants.KEY_CONTENT);
		User user = (User) session.getAttribute(Constants.KEY_USER);
		Date date = issueDAO.getCurrentDate();

		Comment comment = new Comment(++maxCommetnId);

		comment.setContent(content);
		comment.setAddDate(date);
		comment.setAutor(user);

		issueDAO.insertComment(comment, issueDAO.getIssue(issueId));

		jump(Constants.CREATE_UPDATE_ISSUE_CONTROLLER, request, response);
	}
}