/**
 * 
 */
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
	public List<Issue> getListIssue();
	/**
	 * 
	 * @param id Unique object identifier.
	 * @return Object of class Issue.
	 */
	public Issue getIssue(int id);
}
