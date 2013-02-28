package org.training.kparfiankou.issuetracker.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * User: Kiryl Parfiankou.
 * Date: 04.02.13
 * Time: 23:06
 */
public final class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    static {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistryBuilder serviceRegistryBuilder =
                new ServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());

    }

    private HibernateUtil() {
        // Prevent instantiation
    }

    /**
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param session the session
     */
    public static void closeSession(Session session) {

        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
