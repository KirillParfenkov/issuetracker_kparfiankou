package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Build;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.factories.ProjectDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;

/**
 * AbstractController implementation class InsortUpdateProjectController.
 */
public class InsertUpdateProjectController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = null;
    private static long NEW_BUILD = -1;

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

        List<Build> builds = new ArrayList<Build>();
        JSONArray jsonBuilds = null;

        try {
            jsonBuilds = new JSONArray(strBuilds);
            int size = jsonBuilds.length();
            JSONObject jsonBuild = null;

            for (int i = 0; i < size; i++) {
                jsonBuild = jsonBuilds.getJSONObject(i);
                String text = jsonBuild.getString("text");
                long value = Integer.valueOf(jsonBuild.getString("value"));
                builds.add(new Build(value, text));
            }

        } catch (JSONException e) {
        }

        Project project = projectDAO.getProject(projectId);

        for (Build build: builds) {
            if (build.getId() == NEW_BUILD) {
                projectDAO.insertBuild(build);
            }
        }
        project.setBuilds(builds);
        projectDAO.updateProject(project);

		jump(Constants.ADMINISTRATION_PAGE, request, response);
	}
}