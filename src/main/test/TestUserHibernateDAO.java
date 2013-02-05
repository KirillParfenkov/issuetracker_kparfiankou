import org.junit.Assert;
import org.junit.Test;
import org.training.kparfiankou.issuetracker.beans.Password;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.impl.hibernate.UserHibernateDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 19:24
 */
public class TestUserHibernateDAO {

    UserHibernateDAO typeHibernateDAO = new UserHibernateDAO();

    @Test
    public void testUserDAO() {

        int presize = typeHibernateDAO.getListUser().size();

        User user1 = new User();
        user1.setEmailAddress("ABCD@test.com");
        typeHibernateDAO.inserUser(user1, "123");

        User user2 = typeHibernateDAO.getUser("ABCD@test.com");
        Assert.assertNotNull("user2 == null", user2);

        user2.setEmailAddress("ABCD2@test.com");
        typeHibernateDAO.updateUser(user2);
        User user3 = typeHibernateDAO.getUser("ABCD2@test.com");
        Assert.assertNotNull("user3 == null", user3);

        int size = typeHibernateDAO.getListUser().size();

        Assert.assertEquals("" + presize+ " + 1  != " + size, size, presize + 1);

        typeHibernateDAO.removeUser(user2.getId());

        size = typeHibernateDAO.getListUser().size();
        Assert.assertEquals("" + presize+ " != " + size, size, presize);

    }
}
