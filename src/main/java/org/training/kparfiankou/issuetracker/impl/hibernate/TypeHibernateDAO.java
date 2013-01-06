package org.training.kparfiankou.issuetracker.impl.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.impl.database.TypeDatabaseDAO;
import org.training.kparfiankou.issuetracker.impl.hibernate.util.HibernateUtil;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;

//@Repository("typeHibernateDAO")
//@Transactional
public class TypeHibernateDAO implements ITypeDAO {

	//@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	private Session session;

	public TypeHibernateDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession(); 
	}

	@Override
	public List<Type> getListType() {
		return session.createCriteria(Type.class).list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Type getType(long id) {
		return (Type) session.get(Type.class, id);
	}

	@Override
	public Type getType(String nameType) {
		final int numName = 0; 
		return (Type) session.createQuery("select from Type t where t.name = :name").setString(numName, nameType).uniqueResult();
	}

	@Override
	public void updateType(Type type) {
		session.beginTransaction();
		session.update(type);
		session.getTransaction().commit();
	}

	@Override
	public void close() {
		HibernateUtil.closeSession(session);
	}

	@Override
	public void removeType(int id) {
		int numId = 0;
		session.beginTransaction();
		session.createQuery("delete from Type as t where t.id = :id").setLong(numId, id).executeUpdate();
		session.getTransaction().commit();
	}

	@Override
	public void insertType(Type type) {
		session.beginTransaction();
		session.save(type);
		session.getTransaction().commit();
	}

	@Override
	public long getMaxIndex() {
		return (Long) session.createQuery("select max(t.id) from Type t").uniqueResult();
	}
}