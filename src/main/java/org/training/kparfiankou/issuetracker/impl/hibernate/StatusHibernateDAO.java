package org.training.kparfiankou.issuetracker.impl.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.impl.hibernate.util.HibernateUtil;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;

public class StatusHibernateDAO implements IStatusDAO {

	private SessionFactory sessionFactory;
	private Session session;
	
	public StatusHibernateDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Status> getListStatus() {
		return session.createCriteria(Status.class).list();
	}

	@Override
	public Status getStatus(long id) {
		return (Status) session.get(Status.class, id);
	}

	@Override
	public Status getStatus(String nameStatus) {
		final int numName = 0;
		return (Status) session.createQuery("select from Status s where s.name = :name").setString(numName, nameStatus).uniqueResult();
	}

	@Override
	public void updateStatus(Status status) {
		session.beginTransaction();
		session.update(status);
		session.getTransaction().commit();
	}

	@Override
	public void close() {
		HibernateUtil.closeSession(session);
	}

	@Override
	public void removeStatus(long id) {

		final int numId = 0;
		session.beginTransaction();
		session.createQuery("delete from Status as s where s.id = :id").setLong(numId, id).executeUpdate();
		session.getTransaction().commit();
	}

	@Override
	public void insertStatus(Status status) {
		session.beginTransaction();
		session.save(status);
		session.getTransaction().commit();
	}

	@Override
	public long getMaxIndex() {
		return (Long) session.createQuery("select max(s.id) from Status s").uniqueResult();
	}
}