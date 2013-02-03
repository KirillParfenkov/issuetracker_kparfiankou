package org.training.kparfiankou.issuetracker.impl.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.training.kparfiankou.issuetracker.beans.Password;
import org.training.kparfiankou.issuetracker.beans.User;
import org.training.kparfiankou.issuetracker.impl.hibernate.util.HibernateUtil;
import org.training.kparfiankou.issuetracker.interfaces.IUserDAO;

public class UserHibernateDAO implements IUserDAO {

	private SessionFactory sessionFactory;
	private Session session;

	public UserHibernateDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
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
		final int numEmail = 0;
		return (User) session.createQuery("select from User u where u.emailAddress = :emailAddress").setString(numEmail, emailAddress).uniqueResult();
	}

	@Override
	public void inserUser(User user, String password) {
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
		int numId = 0;
		session.beginTransaction();
		session.createQuery("delete from User as u where u.id = :id").setLong(numId, id).executeUpdate();
		session.getTransaction().commit();
	}

	@Override
	public User authenticate(String emailAddres, String password) {
		return getUser(emailAddres); // Temporary solution
	}

	@Override
	public long getMaxIndex() {
		return (Long) session.createQuery("select max(u.id) from User u").uniqueResult();
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

	/**
	 * @param sessionFactory The SessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}