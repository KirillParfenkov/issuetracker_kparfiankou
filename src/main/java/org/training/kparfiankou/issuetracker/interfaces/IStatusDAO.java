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
	Status getStatus(int id);

	/**
	 * @param nameStatus name of type
	 * @return Object of class Status
	 */
	Status getStatus(String nameStatus);

	/**
	 * Close connection with Database.
	 */
	void close();

	/**
	 * @param id of status
	 */
	void removeStatus(int id);

	/**
	 * @param nameStatus name of status
	 */
	void insertStatus(String nameStatus);
}