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
	List<Priority> getListPriority();
	/**
	 *
	 * @param id Unique object identifier.
	 * @return Object of class Priority.
	 */
	Priority getPriority(int id);

	/**
	 * @param namePriority name of type
	 * @return Object of class Priority
	 */
	Priority getPriority(String namePriority);

	/**
	 * Close connection with Database.
	 */
	void close();

	/**
	 * @param id of priority
	 */
	void removePriority(int id);

	/**
	 * @param namePriority name of priority
	 */
	void insertPriority(String namePriority);
}