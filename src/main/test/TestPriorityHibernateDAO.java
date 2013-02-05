import org.junit.Assert;
import org.junit.Test;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.impl.hibernate.PriorityHibernateDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 18:51
 */
public class TestPriorityHibernateDAO {

    PriorityHibernateDAO typeHibernateDAO = new PriorityHibernateDAO();

    @Test
    public void testPriorityDAO() {

        int presize = typeHibernateDAO.getListPriority().size();

        Priority priority1 = new Priority();
        priority1.setName("ABCD");
        typeHibernateDAO.insertPriority(priority1);

        Priority priotity2 = typeHibernateDAO.getPriority("ABCD");
        Assert.assertNotNull("priotity2 == null", priotity2);

        priotity2.setName("ABCD2");
        typeHibernateDAO.updatePriority(priotity2);
        Priority priotity3 = typeHibernateDAO.getPriority("ABCD2");
        Assert.assertNotNull("priotity3 == null", priotity3);

        int size = typeHibernateDAO.getListPriority().size();

        Assert.assertEquals("" + presize+ " + 1  != " + size, size, presize + 1);

        typeHibernateDAO.removePriority(priotity2.getId());

        size = typeHibernateDAO.getListPriority().size();
        Assert.assertEquals("" + presize+ " != " + size, size, presize);

    }
}
