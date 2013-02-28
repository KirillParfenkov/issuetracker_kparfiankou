package org.training.kparfiankou.issuetracker;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.dao.hibernate.ResolutionHibernateDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 18:52
 */
public class TestResolutionHibernateDAO {


    ResolutionHibernateDAO resolutionHibernateDAO = new ResolutionHibernateDAO();

    @Before
    public void testInit() {
        resolutionHibernateDAO = new ResolutionHibernateDAO();
    }

    @Test
    public void testResolutionDAO() {

        int presize = resolutionHibernateDAO.getListResolution().size();

        Resolution resilution1 = new Resolution();
        resilution1.setName("ABCD");
        resolutionHibernateDAO.insertResolution(resilution1);

        Resolution resolution2 = resolutionHibernateDAO.getResolution("ABCD");
        Assert.assertNotNull("resolution2 == null", resolution2);

        resolution2.setName("ABCD2");
        resolutionHibernateDAO.updateResolution(resolution2);
        Resolution resolution3 = resolutionHibernateDAO.getResolution("ABCD2");
        Assert.assertNotNull("resolution3 == null", resolution3);

        int size = resolutionHibernateDAO.getListResolution().size();

        Assert.assertEquals("" + presize + " + 1  != " + size, size, presize + 1);

        resolutionHibernateDAO.removeResolution(resolution2.getId());

        size = resolutionHibernateDAO.getListResolution().size();
        Assert.assertEquals("" + presize+ " != " + size, size, presize);
    }

    @After
    public void testDescturctor() {
        resolutionHibernateDAO.close();
    }
}
