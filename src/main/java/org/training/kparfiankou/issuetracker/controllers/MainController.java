package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.IssueDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;


/**
 * Servlet implementation class MainController.
 */
public class MainController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static final int MAX_COUTN_RECORD = 10;
	private static Logger logger = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
    }

    @Override
    public void init() {
    	logger = Logger.getLogger(LoginController.class);
    }

    @Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String errorMesage = (String) request.getAttribute(Constants.KEY_ERROR_MESAGE);

		IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();
		List<Issue> issues = issueDAO.getListIssue(); // think

		jump(Constants.MAIN_PAGE, request, response);

		/*out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html' charset='utf-8'>");
		printCssStyle(out);

		out.println("</head>");

		out.println("<body>");
		printHeader(session, out);

		if (errorMesage != null) {
			out.println("<div class=error>" + errorMesage + "</div>");
		}

		out.println("<div id=main>");
		out.println("<table>");

		int coutnRecord = (issues.size() > MAX_COUTN_RECORD) ? MAX_COUTN_RECORD : issues.size();

		out.println("<tr class=head>");
		out.println("<td>" + "Id" + "</td>");
		out.println("<td>" + "Priority" + "</td>");
		out.println("<td>" + "Assignee" + "</td>");
		out.println("<td>" + "Type" + "</td>");
		out.println("<td>" + "Status" + "</td>");
		out.println("<td>" + "Summary" + "</td>");
		out.println("</tr>");

		for (int i = 0; i < coutnRecord; i++) {
			out.println("<tr>");
			out.println("<td>" + issues.get(i).getId() + "</td>");
			out.println("<td>" + issues.get(i).getPriority() + "</td>");
			out.println("<td>" + issues.get(i).getAssignee() + "</td>");
			out.println("<td>" + issues.get(i).getType() + "</td>");
			out.println("<td>" + issues.get(i).getStatus() + "</td>");
			out.println("<td>" + issues.get(i).getSummary() + "</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

		request.removeAttribute(Constants.KEY_ERROR_MESAGE);*/
	}

	private void printHeader(HttpSession session, PrintWriter out) {

		User user = (User) session.getAttribute(Constants.KEY_USER);
		out.println("<div id=header>");
		out.println("<form name=headerForm method=POST "
				    + "action=" + Constants.LOGIN_CONTROLLER + " >");

		if (user == null) {
			out.println("<span>Email </span>");
			out.println("<input class=hElem type=text name=" + Constants.KEY_INPUT_EMAIL + " value=\"\">");
			out.println("<span>Password </span>");
			out.println("<input class=hElem type=password name=" + Constants.KEY_INPUT_PASSWORD + " value=\"\">");
			out.println("<input class=hElem type=submit value=\"sign in\">");
		} else {
			out.println("Hi, " + user.getFirstName() + " " + user.getLastName());
			out.println("<a class=hElem href=" + Constants.LOGOUT_CONTROLLER + ">Logout</a>");
		}
		out.println("</form>");
		out.println("</div>");
	}

	private void printCssStyle(PrintWriter out) {

		out.println("<style type=text/css>");
		out.println("#main{ position: absolute; "
				 		 + "top: 15%; "
				         + "left: 25%; "
				         + "width: 50%; "
				         + "height: 70%; "
				         + "overflow: auto;}");
		out.println("#header{ position: absolute; "
						   + "top: 5%; "
						   + "width: 90%; "
						   + "height: 6%; "
						   + "left: 5%; "
						   + "right: 5%; "
						   + "text-align: center;}");
		out.println(".hElem{margin-right: 15pt; width:10em;}");
		out.println("span{margin-right: 5pt;}");
		out.println(".error{ color: red; text-align: center;}");
		out.println(".head{background: gray;}");
		out.println("td{border-bottom: 1pt dotted black}");
		out.println("</style>");
	}
}
