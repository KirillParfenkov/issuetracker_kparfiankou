package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;

/**
 * Servlet implementation class CreateUpdateTypeController.
 */
public class CreateUpdateTypeController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUpdateTypeController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();

		int typeId = Integer.valueOf(request.getParameter(Constants.KEY_TYPE_ID));
		Type type = typeDAO.getType(typeId);

		request.setAttribute(Constants.KEY_TYPE, type);
		typeDAO.close();
		jump(Constants.UPDATE_TYPE_PAGE, request, response);
	}
}