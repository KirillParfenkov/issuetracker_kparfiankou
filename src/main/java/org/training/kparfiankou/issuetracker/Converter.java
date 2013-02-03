package org.training.kparfiankou.issuetracker;

import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.impl.database.PriorityDatabaseDAO;
import org.training.kparfiankou.issuetracker.impl.database.ResolutionDatabaseDAO;
import org.training.kparfiankou.issuetracker.impl.database.StatusDatabaseDAO;
import org.training.kparfiankou.issuetracker.impl.database.TypeDatabaseDAO;
import org.training.kparfiankou.issuetracker.impl.database.UserDatabaseDAO;
import org.training.kparfiankou.issuetracker.impl.hibernate.PriorityHibernateDAO;
import org.training.kparfiankou.issuetracker.impl.hibernate.ResolutionHibernateDAO;
import org.training.kparfiankou.issuetracker.impl.hibernate.StatusHibernateDAO;
import org.training.kparfiankou.issuetracker.impl.hibernate.TypeHibernateDAO;
import org.training.kparfiankou.issuetracker.impl.hibernate.UserHibernateDAO;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

public class Converter {
	public static void deliver() {

		if (false) {
			ITypeDAO typeDatabaseDAO = new TypeDatabaseDAO();
			List<Type> types = typeDatabaseDAO.getListType();

			ITypeDAO typeHibernateDAO = new TypeHibernateDAO();

			for (Type type: types) {
				typeHibernateDAO.insertType(type);	
			}
		}

		if (false) {
			IStatusDAO statusDatabaseDAO = new StatusDatabaseDAO();
			List<Status> statuses = statusDatabaseDAO.getListStatus();

			IStatusDAO statusHibernateDAO = new StatusHibernateDAO();

			for (Status status: statuses) {
				statusHibernateDAO.insertStatus(status);
			}
		}

		if (false) {
			IResolutionDAO resolutionDatabaseDAO = new ResolutionDatabaseDAO();
			List<Resolution> resolutions = resolutionDatabaseDAO.getListResolution();

			IResolutionDAO resolutionHibernateDAO = new ResolutionHibernateDAO();

			for (Resolution resolution: resolutions) {
				resolutionHibernateDAO.insertResolution(resolution);
			}
		}

		if (false) {
			IPriorityDAO priorityDatabaseDAO = new PriorityDatabaseDAO();
			List<Priority> priorities = priorityDatabaseDAO.getListPriority();

			IPriorityDAO priorityHibernateDAO = new PriorityHibernateDAO();

			for (Priority priority: priorities) {
				priorityHibernateDAO.insertPriority(priority);
			}
		}

		if (false) {
			IUserDAO userDatabaseDAO = new UserDatabaseDAO();
			List<User> users = userDatabaseDAO.getListUser();

			IUserDAO userHibernateDAO = new UserHibernateDAO();

			for (User user: users) {
				userHibernateDAO.inserUser(user, "1234567");
			}
		}
	}
}