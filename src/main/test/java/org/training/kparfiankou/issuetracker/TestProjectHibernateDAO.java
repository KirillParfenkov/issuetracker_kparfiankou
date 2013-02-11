package org.training.kparfiankou.issuetracker;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.impl.hibernate.ProjectHibernateDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 20:03
 */
public class TestProjectHibernateDAO {

    ProjectHibernateDAO projectHibernateDAO = new ProjectHibernateDAO();

    @Before
    public void testInit() {
        projectHibernateDAO = new ProjectHibernateDAO();
    }

    @Test
    public void testProjectDAO() {

        int presize = projectHibernateDAO.getListProject().size();

        Project project1 = new Project(projectHibernateDAO.getMaxIndex());
        project1.setName("ABCD");
        projectHibernateDAO.insertProject(project1);


        Project user2 = projectHibernateDAO.getProject(project1.getId());
        Assert.assertNotNull("user2 == null", user2);

        user2.setName("ABCD2");
        projectHibernateDAO.updateProject(user2);
        Project user3 = projectHibernateDAO.getProject(project1.getId());
        Assert.assertEquals("ABCD2 != " + user3.getName(), user3.getName(), "ABCD2");

        int size = projectHibernateDAO.getListProject().size();

        Assert.assertEquals("" + presize + " + 1  != " + size, size, presize + 1);

        projectHibernateDAO.removeProject(user2.getId());

        size = projectHibernateDAO.getListProject().size();
        Assert.assertEquals("" + presize+ " != " + size, size, presize);
    }

    @After
    public void testDescturctor() {
        projectHibernateDAO.close();
    }
}
