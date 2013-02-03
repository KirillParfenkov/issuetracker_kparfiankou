package org.training.kparfiankou.issuetracker.interfaces;

import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Status;

/**
 * @author theparf
 *
 */
public interface IStatusDAO {

	/**
	 * @return List of existing statuses.
	 */
	List<Status> getListStatus();

	/**
	 * @param id Unique object identifier.
	 * @return Object class Status.
	 */
	Status getStatus(long id);

	/**
	 * @param nameStatus name of type
	 * @return Object of class Status
	 */
	Status getStatus(String nameStatus);

	/**
	 * @param status object of class Status
	 */
	void updateStatus(Status status);

	/**
	 * Close connection with Database.
	 */
	void close();

	/**
	 * @param id of status
	 */
	void removeStatus(long id);

	/**
	 * @param nameStatus name of status
	 */
	void insertStatus(Status status);

	/**
	 * @return max index;
	 */
	long getMaxIndex();
}