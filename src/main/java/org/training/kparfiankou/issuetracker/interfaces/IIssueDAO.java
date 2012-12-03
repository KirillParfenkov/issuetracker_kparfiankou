package org.training.kparfiankou.issuetracker.interfaces;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.training.kparfiankou.issuetracker.beans.Comment;
import org.training.kparfiankou.issuetracker.beans.Issue;

/**
 * @author theparf
 *
 */
public interface IIssueDAO {

	/**
	 *
	 * @return List of issues
	 */
	List<Issue> getListIssue();

	/**
	 *
	 * @param id Unique object identifier.
	 * @return Object of class Issue.
	 */
	Issue getIssue(int id);

	/**
	 *
	 * @param issue object of type Issue.
	 */
	void insertIssue(Issue issue);

	/**
	 *
	 * @param id of Issue.
	 */
	void removeIssue(int id);

	/**
	 * Close all connections.
	 */
	void close();

	/**
	 * @return current date.
	 */
	Date getCurrentDate();

	/**
	 * @return max index;
	 */
	int getMaxIndex();

	/**
	 * @param map keys of search.
	 * @return List of existing issues.
	 */
	List<Issue> searchUsers(Map<String, String> map);

	/**
	 * @param issue object of class Issue
	 */
	void updateIssue(Issue issue);

	/**
	 * @param issueId id of issue.
	 * @return comment list.
	 */
	List<Comment> getCommentList(int issueId);

	/**
	 * @return max comment id.
	 */
	int getMaxCommetnId();

	/**
	 * @param comment object of class Comment.
	 * @param issueId id of issue.
	 */
	void insertComment(Comment comment, int issueId);
}