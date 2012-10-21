package org.training.kparfiankou.issuetracker.controllers;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.IssueDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;


/**
 * Servlet implementation class MainController
 */
public class MainController extends AbstractController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
    }

	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		final int COUTN_RECORD = 10;  
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String errorMesage = (String)request.getAttribute(Constants.KEY_ERROR_MESAGE);
		
		IIssueDAO issueDAO = IssueDAOFactory.getClassFromFactory();
		List<Issue> issues = issueDAO.getListIssue();
		
		printHeader(session, out);
		
		if (errorMesage != null){			
			out.println("<div class=error>"+errorMesage+"</div>");
		}
		
		out.println("<div id=main>");
		out.println("<table>");
		
		for (int i = 0; i < COUTN_RECORD; i++){
			out.println("<tr>");
			out.println("<td>" + issues.get(i).getId() + "</td>");
			out.println("<td>" + issues.get(i).getSummary() + "</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</div>");
		
		request.removeAttribute(Constants.KEY_ERROR_MESAGE);	
	}
	
	private void printHeader(HttpSession session, PrintWriter out){
		
		User user = (User) session.getAttribute(Constants.KEY_USER);
		out.println("<div id=header>");
		out.println("<form name=headerForm method=POST " +
				    "action="+ Constants.JUMP_LOGIN_CONTROLLER + " >");

		if (user == null){
			out.println("<input class=hElem type=text name="+ Constants.KEY_INPUT_EMAIL +" value=\"\">");
			out.println("<input class=hElem type=password name="+ Constants.KEY_INPUT_PASSWORD +" value=\"\">");
			out.println("<input class=hElem type=submit value=\"sign in\">");
		}
		else{
			out.println("Hi, " + user.getFirstName() + " " + user.getLastName());
			out.println("<a class=hElem href="+ Constants.JUMP_LOGOUT_CONTROLLER +">Logout</a>");
		}
		out.println("</form>");
		out.println("</div>");
	}
}
