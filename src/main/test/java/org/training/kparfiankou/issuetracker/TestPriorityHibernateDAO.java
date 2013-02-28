package org.training.kparfiankou.issuetracker;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.dao.hibernate.PriorityHibernateDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 18:51
 */
public class TestPriorityHibernateDAO {

    PriorityHibernateDAO priorityHibernateDAO = new PriorityHibernateDAO();

    @Before
    public void testInit() {
        priorityHibernateDAO = new PriorityHibernateDAO();
    }

    @Test
    public void testPriorityDAO() {

        int presize = priorityHibernateDAO.getListPriority().size();

        Priority priority1 = new Priority();
        priority1.setName("ABCD");
        priorityHibernateDAO.insertPriority(priority1);

        Priority priotity2 = priorityHibernateDAO.getPriority("ABCD");
        Assert.assertNotNull("priotity2 == null", priotity2);

        priotity2.setName("ABCD2");
        priorityHibernateDAO.updatePriority(priotity2);
        Priority priotity3 = priorityHibernateDAO.getPriority("ABCD2");
        Assert.assertNotNull("priotity3 == null", priotity3);

        int size = priorityHibernateDAO.getListPriority().size();

        Assert.assertEquals("" + presize + " + 1  != " + size, size, presize + 1);

        priorityHibernateDAO.removePriority(priotity2.getId());

        size = priorityHibernateDAO.getListPriority().size();
        Assert.assertEquals("" + presize+ " != " + size, size, presize);
    }

    @After
    public void testDescturctor() {
        priorityHibernateDAO.close();
    }
}
