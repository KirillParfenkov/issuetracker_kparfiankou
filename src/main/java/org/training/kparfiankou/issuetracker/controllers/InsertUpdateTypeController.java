package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;

/**
 * AbstractController implementation class InsertUpdateTypeController.
 */
public class InsertUpdateTypeController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private static Logger logger = null;

	private static final String INFO_UPDATE_TYPE = "Type was updated.";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUpdateTypeController() {
        super();
    }

    @Override
    public void init() {
    	logger = Logger.getLogger(InsertUpdateTypeController.class);
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
		int typeId = Integer.valueOf(request.getParameter(Constants.KEY_TYPE_ID));
		String typeName = request.getParameter(Constants.KEY_NAME);

		Type type = typeDAO.getType(typeId);
		type.setName(typeName);
		typeDAO.updateType(type);

		logger.info(INFO_UPDATE_TYPE + " " + typeName);
		request.setAttribute(Constants.KEY_TYPES, typeDAO.getListType());

		typeDAO.close();
		jump(Constants.CREATE_TYPES_LIST_PAGE_CONTROLLER, request, response);
	}
}