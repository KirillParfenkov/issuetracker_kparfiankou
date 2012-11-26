package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.factories.ResolutionDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;

/**
 * AbstractController implementation class InsertUpdateResolutionController.
 */
public class InsertUpdateResolutionController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = null;

	private static final String INFO_UPDATE_STATUS = "Status was updated.";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUpdateResolutionController() {
        super();
    }

    @Override
    public void init() {
    	logger = Logger.getLogger(InsertUpdateResolutionController.class);
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IResolutionDAO resolutionDAO = ResolutionDAOFactory.getClassFromFactory();
		int resolutionId = Integer.valueOf(request.getParameter(Constants.KEY_RESOLUTION_ID));
		String resolutionName = request.getParameter(Constants.KEY_NAME);

		Resolution resolution = resolutionDAO.getResolution(resolutionId);
		resolution.setName(resolutionName);
		resolutionDAO.updateResolution(resolution);

		logger.info(INFO_UPDATE_STATUS + " " + resolutionName);
		request.setAttribute(Constants.KEY_RESOLUTIONS, resolutionDAO.getListResolution());

		resolutionDAO.close();
		jump(Constants.CREATE_RESOLUTIONS_LIST_PAGE_CONTROLLER, request, response);
	}
}