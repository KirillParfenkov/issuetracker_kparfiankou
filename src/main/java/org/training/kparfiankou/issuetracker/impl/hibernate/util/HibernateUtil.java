package org.training.kparfiankou.issuetracker.impl.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	static {

			Configuration configuration = new Configuration(); 
			configuration.configure("hibernate.cfg.xml");
			ServiceRegistryBuilder serviceRegistryBuilder =  new ServiceRegistryBuilder().applySettings(configuration.getProperties());
			sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
	}

	static public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	static public void closeSession(Session session){

		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}