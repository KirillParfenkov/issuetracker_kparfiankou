package org.training.kparfiankou.issuetracker.controllers;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Build;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.factories.ProjectDAOFactory;
import org.training.kparfiankou.issuetracker.factories.UserDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 10.02.13
 * Time: 2:56
 */
public class InsertAddingProjectController extends AbstractController {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAddingProjectController() {
        super();
    }

    @Override
    protected void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
        IUserDAO userDAO = UserDAOFactory.getClassFromFactory();

        String name = request.getParameter(Constants.KEY_NAME);
        String description = request.getParameter(Constants.KEY_DESCRIPTION);
        String nameBuild = request.getParameter(Constants.KEY_BUILD);
        long managerId = Integer.valueOf(request.getParameter(Constants.KEY_MANAGER));
        User manager = userDAO.getUser(managerId);
      //  long maxProjectId = projectDAO.getMaxIndex();

        Build build = new Build();
        build.setName(nameBuild);
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        project.addBuild(build);
        project.setManager(manager);
  //      project.setId(++maxProjectId);

        projectDAO.insertProject(project);

        jump(Constants.ADMINISTRATION_PAGE, request, response);
    }

}
