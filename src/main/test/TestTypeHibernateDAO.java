import org.junit.Assert;
import org.junit.Test;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.impl.hibernate.TypeHibernateDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 1:14
 */
public class TestTypeHibernateDAO {

    TypeHibernateDAO typeHibernateDAO = new TypeHibernateDAO();

    @Test
    public void testTypeDAO() {

        int presize = typeHibernateDAO.getListType().size();

        Type type1 = new Type();
        type1.setName("ABCD");
        typeHibernateDAO.insertType(type1);

        Type type2 = typeHibernateDAO.getType("ABCD");
        Assert.assertNotNull("type2 == null", type2);

        type2.setName("ABCD2");
        typeHibernateDAO.updateType(type2);
        Type type3 = typeHibernateDAO.getType("ABCD2");
        Assert.assertNotNull("type3 == null", type3);

        int size = typeHibernateDAO.getListType().size();

        Assert.assertEquals("" + presize+ " + 1  != " + size, size, presize + 1);

        typeHibernateDAO.removeType(type2.getId());

        size = typeHibernateDAO.getListType().size();
        Assert.assertEquals("" + presize+ " != " + size, size, presize);

    }
}