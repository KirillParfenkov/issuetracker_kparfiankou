package org.training.kparfiankou.issuetracker.impl.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.impl.hibernate.util.HibernateUtil;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;

public class ResolutionHibernateDAO implements IResolutionDAO {

	private SessionFactory sessionFactory;
	private Session session;

	public ResolutionHibernateDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession(); 
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Resolution> getListResolution() {
		return session.createCriteria(Resolution.class).list();
	}

	@Override
	public Resolution getResolution(long id) {
		return (Resolution) session.get(Resolution.class, id);
	}

	@Override
	public Resolution getResolution(String nameResolution) {
		final int numName = 0; 
		return (Resolution) session.createQuery("select from Resolution r where r.name = :name").setString(numName, nameResolution).uniqueResult();
	}

	@Override
	public void updateResolution(Resolution resolution) {
		session.beginTransaction();
		session.update(resolution);
		session.getTransaction().commit();
	}

	@Override
	public void close() {
		HibernateUtil.closeSession(session);
	}

	@Override
	public void removeResolution(long id) {
		int numId = 0;
		session.beginTransaction();
		session.createQuery("delete from Resolution as r where r.id = :id").setLong(numId, id).executeUpdate();
		session.getTransaction().commit();
	}

	@Override
	public void insertResolution(Resolution resolution) {
		session.beginTransaction();
		session.save(resolution);
		session.getTransaction().commit();
	}

	@Override
	public long getMaxIndex() {
		return (Long) session.createQuery("select max(r.id) from Resolution r").uniqueResult();
	}
}
