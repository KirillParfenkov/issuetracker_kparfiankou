package org.training.kparfiankou.issuetracker;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.dao.hibernate.StatusHibernateDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 1:14
 */
public class TestStatusHibernateDAO {

    StatusHibernateDAO statusHibernateDAO = new StatusHibernateDAO();

    @Before
    public void testInit() {
        statusHibernateDAO = new StatusHibernateDAO();
    }

    @Test
    public void demoInit() {
        //"New, Assigned, In Progress, Resolved, Closed, Reopened"
        Status status;
        if (statusHibernateDAO.getStatus("New") == null) {
            status = new Status();
            status.setName("New");
            statusHibernateDAO.insertStatus(status);
        }
        if (statusHibernateDAO.getStatus("Assigned") == null) {
            status = new Status();
            status.setName("Assigned");
            statusHibernateDAO.insertStatus(status);
        }
        if (statusHibernateDAO.getStatus("In Progress") == null) {
            status = new Status();
            status.setName("In Progress");
            statusHibernateDAO.insertStatus(status);
        }
        if (statusHibernateDAO.getStatus("Resolved") == null) {
            status = new Status();
            status.setName("Resolved");
            statusHibernateDAO.insertStatus(status);
        }
        if (statusHibernateDAO.getStatus("Closed") == null) {
            status = new Status();
            status.setName("Closed");
            statusHibernateDAO.insertStatus(status);
        }
        if (statusHibernateDAO.getStatus("Reopened") == null) {
            status = new Status();
            status.setName("Reopened");
            statusHibernateDAO.insertStatus(status);
        }
    }

    @Test
    public void testStatusDAO() {

        int presize = statusHibernateDAO.getListStatus().size();

        Status status1 = new Status();
        status1.setName("ABCD");
        statusHibernateDAO.insertStatus(status1);

        Status status2 = statusHibernateDAO.getStatus("ABCD");
        Assert.assertNotNull("status2 == null", status2);

        status2.setName("ABCD2");
        statusHibernateDAO.updateStatus(status2);
        Status status3 = statusHibernateDAO.getStatus("ABCD2");
        Assert.assertNotNull("status3 == null", status3);

        int size = statusHibernateDAO.getListStatus().size();

        Assert.assertEquals("" + presize + " + 1  != " + size, size, presize + 1);

        statusHibernateDAO.removeStatus(status2.getId());

        size = statusHibernateDAO.getListStatus().size();
        Assert.assertEquals("" + presize+ " != " + size, size, presize);

    }

    @After
    public void testDescturctor() {
        statusHibernateDAO.close();
    }
}