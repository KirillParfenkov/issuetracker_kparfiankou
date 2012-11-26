package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;

/**
 * AbstractController implementation class CreateTypeListPageController.
 */
public class CreateTypesListPageController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTypesListPageController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
		List<Type> list = typeDAO.getListType();

		request.setAttribute(Constants.KEY_TYPES, list);

		jump(Constants.TYPES_LIST_PAGE, request, response);

	}


}