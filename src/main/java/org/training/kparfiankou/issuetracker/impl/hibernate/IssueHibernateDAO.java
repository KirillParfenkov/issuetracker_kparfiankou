package org.training.kparfiankou.issuetracker.impl.hibernate;

import org.hibernate.Session;
import org.training.kparfiankou.issuetracker.beans.Comment;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.interfaces.IIssueDAO;
import org.training.kparfiankou.issuetracker.util.HibernateUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 07.02.13
 * Time: 3:05
 */
public class IssueHibernateDAO implements IIssueDAO {

    private Session session;

    public IssueHibernateDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public List<Issue> getListIssue() {
        return session.createCriteria(Issue.class).list();
    }

    @Override
    public Issue getIssue(long id) {
        return (Issue) session.get(Issue.class, id);
    }

    @Override
    public void insertIssue(Issue issue) {
        session.beginTransaction();
        session.save(issue);
        session.getTransaction().commit();
    }

    @Override
    public void removeIssue(long id) {
        session.beginTransaction();
        session.createQuery("delete from Comment as c where c.issue.id = :id").setLong("id", id).executeUpdate();
        session.createQuery("delete from Issue as i where i.id = :id").setLong("id", id).executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void close() {
        HibernateUtil.closeSession(session);
    }

    @Override
    public Date getCurrentDate() {
        //return (Date) session.createQuery("select CURRENT_DATE() from  Issue ").uniqueResult();
        return new Date();
    }

    @Override
    public long getMaxIndex() {
        Object index = session.createQuery("select max(i.id) from Issue i").uniqueResult();
        if (index != null) {
            return  (Long) index;
        }
        return 0;
    }

    @Override
    public List<Issue> searchUsers(Map<String, String> map) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateIssue(Issue issue) {
        session.beginTransaction();
        session.update(issue);
        session.getTransaction().commit();
    }

    @Override
    public List<Comment> getCommentList(long issueId) {
        Issue issue = (Issue) session.get(Issue.class, issueId);
        return session.createQuery("from Comment as c where c.issue.id = :issue_id ")
                .setParameter("issue_id", issueId).list();
    }

    @Override
    public long getMaxCommetnId() {
        Object index = session.createQuery("select max(c.id) from Comment c").uniqueResult();
        if (index != null) {
            return  (Long) index;
        }
        return 0;
    }

    @Override
    public void insertComment(Comment comment, Issue issue) {
       session.beginTransaction();
       comment.setIssue(issue);
       session.save(comment);
       session.getTransaction().commit();
    }
}
