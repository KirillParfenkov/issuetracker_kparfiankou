package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.factories.ProjectDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;

/**
 * AbstractController implementation class InsortUpdateProjectController.
 */
public class InsertUpdateProjectController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = null;

	private static final String INFO_UPDATE_PROJECT = "PROJECT was updated.";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUpdateProjectController() {
        super();
    }

    @Override
    public void init() {
    	logger = Logger.getLogger(InsertUpdateProjectController.class);
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IProjectDAO projectDAO = ProjectDAOFactory.getClassFromFacroty();
		int projectId = Integer.valueOf(request.getParameter(Constants.KEY_PROJECT_ID));
        String strBuilds = request.getParameter(Constants.KEY_BUILDS);

        JSONArray jsonBuilds = null;
        try {
            jsonBuilds = new JSONArray(strBuilds);
            JSONObject jsonBuild = jsonBuilds.getJSONObject(0);
            String test = jsonBuild.getString("text");
            String value = jsonBuild.getString("value");

            logger.info(test + "  " + value);

        } catch (JSONException e) {
        }

        //Project project = projectDAO.getProject(projectId);

		//request.setAttribute(Constants.KEY_PROJECT, project);

		jump(Constants.ADMINISTRATION_PAGE, request, response);
	}
}