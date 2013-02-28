package org.training.kparfiankou.issuetracker.impl.hibernate;

import org.hibernate.Session;
import org.training.kparfiankou.issuetracker.beans.Resolution;
import org.training.kparfiankou.issuetracker.interfaces.IResolutionDAO;
import org.training.kparfiankou.issuetracker.util.HibernateUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 18:37
 */
public class ResolutionHibernateDAO implements IResolutionDAO {

    private Session session;

    /**
     * Default constructor.
     */
    public ResolutionHibernateDAO() {
        session = HibernateUtil.getSessionFactory().openSession();

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
        final String paramName = "name";
        return (Resolution) session.createQuery("from Resolution as r where r.name = :name")
                .setString(paramName, nameResolution).uniqueResult();
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
        session.createQuery("delete from Resolution as r where r.id = :id").setLong("id", id).executeUpdate();
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
        Object index = session.createQuery("select max(r.id) from Resolution r").uniqueResult();
        if (index != null) {
            return  (Long) index;
        }
        return 0;
    }
}
