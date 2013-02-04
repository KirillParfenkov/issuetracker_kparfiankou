package org.training.kparfiankou.issuetracker.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.training.kparfiankou.issuetracker.beans.Type;
import org.training.kparfiankou.issuetracker.interfaces.ITypeDAO;
import org.training.kparfiankou.issuetracker.util.HibernateUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 05.02.13
 * Time: 0:52
 */
public class TypeHibernateDAO implements ITypeDAO {

    private Session session;

    /**
     * Default constructor.
     */
    public TypeHibernateDAO() {
        session = HibernateUtil.getSessionFactory().openSession();

    }

    @Override
    public List<Type> getListType() {
        return session.createCriteria(Type.class).list();
    }

    @Override
    public Type getType(long id) {
        return (Type) session.get(Type.class, id);
    }

    @Override
    public Type getType(String nameType) {
        final String paramName = "name";
        return (Type) session.createQuery("from Type as t where t.name = :name")
                .setString(paramName, nameType).uniqueResult();
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
    public void removeType(long id) {
        int numId = 0;
        session.beginTransaction();
        session.createQuery("delete from Type as t where t.id = :id").setLong("id", id).executeUpdate();
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