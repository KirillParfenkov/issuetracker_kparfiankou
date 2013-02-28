package org.training.kparfiankou.issuetracker.impl.hibernate;

import org.hibernate.Session;
import org.training.kparfiankou.issuetracker.beans.Status;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.interfaces.IStatusDAO;
import org.training.kparfiankou.issuetracker.util.HibernateUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 2:15
 */
public class StatusHibernateDAO implements IStatusDAO {

    private Session session;

    /**
     * Default constructor.
     */
    public StatusHibernateDAO() {
        session = HibernateUtil.getSessionFactory().openSession();

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
        final String paramName = "name";
        return (Status) session.createQuery("from Status as s where s.name = :name")
                .setString(paramName, nameStatus).uniqueResult();
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
        int numId = 0;
        session.beginTransaction();
        session.createQuery("delete from Status as s where s.id = :id").setLong("id", id).executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void insertStatus(Status status) {
        session.beginTransaction();
        session.save(status);
        session.getTransaction().commit();
    }
}