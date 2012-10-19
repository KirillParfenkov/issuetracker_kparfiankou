package org.training.kparfiankou.issuetracker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ResolutionDAOFactory;
import org.training.kparfiankou.issuetracker.factories.StatusDAOFactory;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.impl.TypeXMLDAO;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;

/**
 * Sample Servlet interface implementation.
 */
public class SampleServlet implements Servlet {

	private ServletConfig servletConfig;

	@Override
	public void init(ServletConfig config) throws ServletException {
		servletConfig = config;
	}

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		return "Sample Servlet interface implementation";
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Sample Servlet interface implementation</title>");
		out.println("</head>");
		out.println("<body>");
		
		
		out.println("Types: <br>");
		ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory(); 
		List<Type> types = typeDAO.getListType();
		
		for(Type type: types){
			out.println(type.getName() + "<br>");
		}
		
		out.println("<b>Statuses:</b> <br>");
		IStatusDAO statusDAO = StatusDAOFactory.getClassFromFactory();
		List<Status> statuses = statusDAO.getListStatus();
		
		for(Status status: statuses){
			out.println(status.getName() + "<br>");
		}
		
		out.println("Prioritys: <br>");
		IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
		List<Priority> prioritys = priorityDAO.getListPriority();
		
		for(Priority priority: prioritys){
			out.println(priority.getName() + "<br>");
		}
		
		out.println("Resolutions: <br>");
		IResolutionDAO resolutionDAO = ResolutionDAOFactory.getClassFromFactory();
		List<Resolution> resolutions = resolutionDAO.getListResolution();
		
		for(Resolution resolution: resolutions){
			out.println(resolution.getName() + "<br>");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
