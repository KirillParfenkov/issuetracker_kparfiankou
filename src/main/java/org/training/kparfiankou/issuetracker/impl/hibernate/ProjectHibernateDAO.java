package org.training.kparfiankou.issuetracker.impl.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.training.kparfiankou.issuetracker.beans.Build;
import org.training.kparfiankou.issuetracker.beans.Project;
import org.training.kparfiankou.issuetracker.interfaces.IProjectDAO;
import org.training.kparfiankou.issuetracker.util.HibernateUtil;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 19:58
 */
public class ProjectHibernateDAO implements IProjectDAO {

    private Session session;

    public ProjectHibernateDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
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
        List<Build> builds = project.getBuilds();
        session.beginTransaction();
        for (Build build: builds) {
            session.save(build);
        }
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
        session.beginTransaction();
        session.createQuery("delete from Project as p where p.id = :id").setLong("id", id).executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void close() {
        HibernateUtil.closeSession(session);
    }

    @Override
    public long getMaxIndex() {
        Object index = session.createQuery("select max(p.id) from Project p").uniqueResult();
        if (index != null) {
            return  (Long) index;
        }
        return 0;
    }
}