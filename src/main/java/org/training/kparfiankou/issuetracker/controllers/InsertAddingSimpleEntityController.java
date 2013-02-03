package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;
import org.training.kparfiankou.issuetracker.ClassEntity;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.factories.PriorityDAOFactory;
import org.training.kparfiankou.issuetracker.factories.ResolutionDAOFactory;
import org.training.kparfiankou.issuetracker.factories.TypeDAOFactory;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;

/**
 * AbstractController implementation class InsertAddingSimpleEntityController.
 */
public class InsertAddingSimpleEntityController extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAddingSimpleEntityController() {
        super();
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ClassEntity entity = ClassEntity.valueOf(request.getParameter(Constants.KEY_TYPE_ENTITY));
		String name = request.getParameter(Constants.KEY_NAME);
		ITypeDAO typeDAO = TypeDAOFactory.getClassFromFactory();
		IPriorityDAO priorityDAO = PriorityDAOFactory.getClassFromFactory();
		IResolutionDAO resolutionDAO = ResolutionDAOFactory.getClassFromFactory();
		long maxId;

		if (ClassEntity.TYPE.equals(entity)) {
			maxId = typeDAO.getMaxIndex();
			typeDAO.insertType(new Type(++maxId, name));
		}

		if (ClassEntity.PRIORITY.equals(entity)) {
			maxId = priorityDAO.getMaxIndex();
			priorityDAO.insertPriority(new Priority(++maxId, name));
		}

		if (ClassEntity.RESOLUTION.equals(entity)) {
			maxId = resolutionDAO.getMaxIndex();
			resolutionDAO.insertResolution(new Resolution(++maxId, name));
		}

		typeDAO.close();
		resolutionDAO.close();
		priorityDAO.close();


		jump(Constants.ADMINISTRATION_PAGE , request, response);
	}
}