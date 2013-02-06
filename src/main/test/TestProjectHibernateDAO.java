import org.junit.Assert;
import org.junit.Test;
import org.training.kparfiankou.issuetracker.beans.Build;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.impl.hibernate.ProjectHibernateDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 20:03
 */
public class TestProjectHibernateDAO {

    ProjectHibernateDAO typeHibernateDAO = new ProjectHibernateDAO();

    @Test
    public void testProjectDAO() {

        int presize = typeHibernateDAO.getListProject().size();

        Project project1 = new Project(typeHibernateDAO.getMaxIndex());
        project1.setName("ABCD");
        typeHibernateDAO.insertProject(project1);


        Project user2 = typeHibernateDAO.getProject(project1.getId());
        Assert.assertNotNull("user2 == null", user2);

        user2.setName("ABCD2");
        typeHibernateDAO.updateProject(user2);
        Project user3 = typeHibernateDAO.getProject(project1.getId());
        Assert.assertEquals("ABCD2 != " + user3.getName(), user3.getName(),"ABCD2");

        int size = typeHibernateDAO.getListProject().size();

        Assert.assertEquals("" + presize+ " + 1  != " + size, size, presize + 1);

        typeHibernateDAO.removeProject(user2.getId());

        size = typeHibernateDAO.getListProject().size();
        Assert.assertEquals("" + presize+ " != " + size, size, presize);

    }
}
