package org.training.kparfiankou.issuetracker.impl.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.impl.hibernate.util.HibernateUtil;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;

public class ProjectHibernateDAO implements IProjectDAO {
	
	private SessionFactory sessionFactory;
	private Session session;
	
	public ProjectHibernateDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
	}

	@Override
	public List<Project> getListProject() {
		return session.createCriteria(Project.class).list();
	}

	@Override
	public Project getProject(long id) {
		return (Project) session.get(Project.class, id);
	}

	@Override
	public void insertProject(Project project) {
		session.beginTransaction();
		session.save(project);
		session.getTransaction().commit();	
	}

	@Override
	public void updateProject(Project project) {
		session.beginTransaction();
		session.update(project);
		session.getTransaction().commit();
	}

	@Override
	public void removeProject(long id) {
		final int numId = 0;
		session.beginTransaction();
		session.createQuery("delete from Project as p where p.id = :id").setLong(numId, id).executeUpdate();
		session.getTransaction().commit();
	}

	@Override
	public void close() {
		HibernateUtil.closeSession(session);
	}
}