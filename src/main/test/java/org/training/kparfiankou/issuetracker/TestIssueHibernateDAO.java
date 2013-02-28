package org.training.kparfiankou.issuetracker;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.training.kparfiankou.issuetracker.beans.Comment;
import org.training.kparfiankou.issuetracker.beans.Issue;
import org.training.kparfiankou.issuetracker.impl.hibernate.IssueHibernateDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kiryl Parfiankou
 * Date: 07.02.13
 * Time: 3:09
 */
public class TestIssueHibernateDAO {

    IssueHibernateDAO issueHibernateDAO;

    @Before
    public void testInit() {
        issueHibernateDAO = new IssueHibernateDAO();
    }

    @Test
    public void testIssueDAO() {

        Issue issue = new Issue();
        issue.setDescription("AAAA");
        issue.setId(issueHibernateDAO.getMaxIndex());


        Comment comment = new Comment();
        comment.setAddDate(issueHibernateDAO.getCurrentDate());
        comment.setContent("AAAA BBBB Comment date!");

        issueHibernateDAO.insertIssue(issue);
        issueHibernateDAO.getIssue(issue.getId());
        issueHibernateDAO.insertComment(comment, issue);

        List<Comment> listComment = issueHibernateDAO.getCommentList(issue.getId());

        Assert.assertTrue("List of comments is empty" , listComment.size() > 0);

        issueHibernateDAO.removeIssue(issue.getId());
    }

    @After
    public void testDescturctor() {
        issueHibernateDAO.close();
    }
}