import org.junit.Assert;
import org.junit.Test;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.impl.hibernate.StatusHibernateDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 1:14
 */
public class TestStatusHibernateDAO {

    StatusHibernateDAO statusHibernateDAO = new StatusHibernateDAO();

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
}