package org.training.kparfiankou.issuetracker.impl.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.impl.hibernate.util.HibernateUtil;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;

public class PriorityHibernateDAO implements IPriorityDAO {

	private SessionFactory sessionFactory;
	private Session session;

	public PriorityHibernateDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession(); 
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Priority> getListPriority() {
		return session.createCriteria(Priority.class).list();
	}

	@Override
	public Priority getPriority(long id) {
		return (Priority) session.get(Priority.class, id);
	}

	@Override
	public Priority getPriority(String namePriority) {
		final int numName = 0; 
		return (Priority) session.createQuery("select from Priority p where p.name = :name").setString(numName, namePriority).uniqueResult();
	}

	@Override
	public void updatePriority(Priority priority) {
		session.beginTransaction();
		session.update(priority);
		session.getTransaction().commit();
	}

	@Override
	public void close() {
		HibernateUtil.closeSession(session);
	}

	@Override
	public void removePriority(long id) {
		int numId = 0;
		session.beginTransaction();
		session.createQuery("delete from Priority as p where p.id = :id").setLong(numId, id).executeUpdate();
		session.getTransaction().commit();
	}

	@Override
	public void insertPriority(Priority priority) {
		session.beginTransaction();
		session.save(priority);
		session.getTransaction().commit();
	}

	@Override
	public long getMaxIndex() {
		return (Long) session.createQuery("select max(p.id) from Priority p").uniqueResult();
	}
}