import org.junit.Assert;
import org.junit.Test;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.impl.hibernate.ResolutionHibernateDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 18:52
 */
public class TestResolutionHibernateDAO {


    ResolutionHibernateDAO typeHibernateDAO = new ResolutionHibernateDAO();

    @Test
    public void testResolutionDAO() {

        int presize = typeHibernateDAO.getListResolution().size();

        Resolution resilution1 = new Resolution();
        resilution1.setName("ABCD");
        typeHibernateDAO.insertResolution(resilution1);

        Resolution resolution2 = typeHibernateDAO.getResolution("ABCD");
        Assert.assertNotNull("resolution2 == null", resolution2);

        resolution2.setName("ABCD2");
        typeHibernateDAO.updateResolution(resolution2);
        Resolution resolution3 = typeHibernateDAO.getResolution("ABCD2");
        Assert.assertNotNull("resolution3 == null", resolution3);

        int size = typeHibernateDAO.getListResolution().size();

        Assert.assertEquals("" + presize+ " + 1  != " + size, size, presize + 1);

        typeHibernateDAO.removeResolution(resolution2.getId());

        size = typeHibernateDAO.getListResolution().size();
        Assert.assertEquals("" + presize+ " != " + size, size, presize);

    }
}
