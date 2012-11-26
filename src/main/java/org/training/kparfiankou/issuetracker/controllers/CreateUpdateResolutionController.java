package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.factories.ResolutionDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;

/**
 * AbstractController implementation class CreateUpdateResolutionController.
 */
public class CreateUpdateResolutionController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUpdateResolutionController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IResolutionDAO resolutionDAO = ResolutionDAOFactory.getClassFromFactory();

		int resolutionId = Integer.valueOf(request.getParameter(Constants.KEY_RESOLUTION_ID));
		Resolution resolution = resolutionDAO.getResolution(resolutionId);

		request.setAttribute(Constants.KEY_RESOLUTION, resolution);
		resolutionDAO.close();
		jump(Constants.UPDATE_RESOLUTION_PAGE, request, response);
	}
}