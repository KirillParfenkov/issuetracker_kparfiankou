package org.training.kparfiankou.issuetracker.dao.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.training.kparfiankou.issuetracker.beans.Role;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.dao.IUserDAO;
import org.training.kparfiankou.issuetracker.util.HibernateUtil;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 19:16
 */
public class UserHibernateDAO implements IUserDAO {


    private Session session;

    public UserHibernateDAO() {

        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public List<User> getListUser() {
        return session.createCriteria(User.class).list();
    }

    @Override
    public User getUser(long id) {
        return (User) session.get(User.class, id);
    }

    @Override
    public User getUser(String emailAddress) {
        User user = (User) session.createQuery("from User as u where u.emailAddress = :emailAddress").setString("emailAddress", emailAddress).uniqueResult();
        if (user == null) {
            user = new User();
            user.setEmailAddress(emailAddress);
            user.setFirstName("Tom");
            user.setLastName("Tomson");
            user.setRole(Role.ADMINISTRATOR);
            user.setId(1 + getMaxIndex());
            insertUser(user, "1234567");
        }
        return user;
    }

    @Override
    public void insertUser(User user, String password) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit(); // Temporary solution
    }

    @Override
    public void updateUser(User user) {
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    @Override
    public void removeUser(long id) {
        session.beginTransaction();
        session.createQuery("delete from User as u where u.id = :id").setLong("id", id).executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public User authenticate(String emailAddres, String password) {
        return getUser(emailAddres); // Temporary solution
    }

    @Override
    public long getMaxIndex() {
        Object index = session.createQuery("select max(u.id) from User u").uniqueResult();
        if (index != null) {
            return  (Long) index;
        }
        return 0;
    }

    @Override
    public void close() {
        HibernateUtil.closeSession(session);
    }

    @Override
    public List<User> searchUsers(Map<String, String> map) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void newPassword(long id, String password) {
        // TODO Auto-generated method stub
    }
}