package org.training.kparfiankou.issuetracker;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.dao.hibernate.UserHibernateDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 19:24
 */
public class TestUserHibernateDAO {

    UserHibernateDAO userHibernateDAO = new UserHibernateDAO();

    @Before
    public void testInit() {
        userHibernateDAO = new UserHibernateDAO();
    }

    @Test
    public void testUserDAO() {

        int presize = userHibernateDAO.getListUser().size();

        User user1 = new User();
        user1.setEmailAddress("ABCD@test.com");
        userHibernateDAO.insertUser(user1, "123");

        User user2 = userHibernateDAO.getUser("ABCD@test.com");
        Assert.assertNotNull("user2 == null", user2);

        user2.setEmailAddress("ABCD2@test.com");
        userHibernateDAO.updateUser(user2);
        User user3 = userHibernateDAO.getUser("ABCD2@test.com");
        Assert.assertNotNull("user3 == null", user3);

        int size = userHibernateDAO.getListUser().size();

        Assert.assertEquals("" + presize + " + 1  != " + size, size, presize + 1);

        userHibernateDAO.removeUser(user2.getId());

        size = userHibernateDAO.getListUser().size();
        Assert.assertEquals("" + presize+ " != " + size, size, presize);

    }

    @After
    public void testDescturctor() {
        userHibernateDAO.close();
    }
}
