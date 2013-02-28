package org.training.kparfiankou.issuetracker.impl.hibernate;

import org.hibernate.Session;
import org.training.kparfiankou.issuetracker.beans.Priority;
import org.training.kparfiankou.issuetracker.interfaces.IPriorityDAO;
import org.training.kparfiankou.issuetracker.util.HibernateUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 18:45
 */
public class PriorityHibernateDAO implements IPriorityDAO{

    private Session session;

    /**
     * Default constructor.
     */
    public PriorityHibernateDAO() {
        session = HibernateUtil.getSessionFactory().openSession();

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
        final String paramName = "name";
        return (Priority) session.createQuery("from Priority as p where p.name = :name")
                .setString(paramName, namePriority).uniqueResult();
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
        session.createQuery("delete from Priority as p where p.id = :id").setLong("id", id).executeUpdate();
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
        Object index = session.createQuery("select max(p.id) from Priority p").uniqueResult();
        if (index != null) {
            return  (Long) index;
        }
        return 0;
    }
}
