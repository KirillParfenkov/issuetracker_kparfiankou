/**
 * 
 */
package org.training.kparfiankou.issuetracker.interfaces;

import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Priority;

/**
 * @author theparf
 *
 */
public interface IPriorityDAO {
	/**
	 * 
	 * @return List of possible prioritys.
	 */
	public List<Priority> getListPriority();
	/**
	 * 
	 * @param id Unique object identifier.
	 * @return Object of class Priority.
	 */
	public Priority getPriority(int id);
}
