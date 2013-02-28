package org.training.kparfiankou.issuetracker;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.training.kparfiankou.issuetracker.util.HibernateUtil;

/**
 * User: Kiryl Parfiankou
 * Date: 04.02.13
 * Time: 23:46
 */
public class TestHibernateUtil {

    @Test
    public void testGettingSessionFactory() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Assert.assertNotNull("Failed to create SessionFactory",sessionFactory);
    }
}
