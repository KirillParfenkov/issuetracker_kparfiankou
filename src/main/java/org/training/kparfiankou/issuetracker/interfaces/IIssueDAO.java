package org.training.kparfiankou.issuetracker.interfaces;

import java.util.List;

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
}