package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.factories.ResolutionDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;

/**
 * AbstractController implementation class CreateResolutionsListPageController.
 */
public class CreateResolutionsListPageController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateResolutionsListPageController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		IResolutionDAO resolutionDAO = ResolutionDAOFactory.getClassFromFactory();
		List<Resolution> list = resolutionDAO.getListResolution();

		request.setAttribute(Constants.KEY_RESOLUTIONS, list);

		jump(Constants.RESOLUTIONS_LIST_PAGE, request, response);
	}
}