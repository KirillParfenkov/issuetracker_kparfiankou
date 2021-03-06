package org.training.kparfiankou.issuetracker.dao;

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
	Priority getPriority(long id);

	/**
	 * @param namePriority name of type
	 * @return Object of class Priority
	 */
	Priority getPriority(String namePriority);

	/**
	 * @param priority object of class Priority
	 */
	void updatePriority(Priority priority);

	/**
	 * Close connection with Database.
	 */
	void close();

	/**
	 * @param id of priority
	 */
	void removePriority(long id);

	/**
	 * @param priority object of class Priority
	 */
	void insertPriority(Priority priority);

	/**
	 * @return max index;
	 */
	long getMaxIndex();
}