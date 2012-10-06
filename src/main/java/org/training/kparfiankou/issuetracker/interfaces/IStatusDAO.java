/**
 * 
 */
package org.training.kparfiankou.issuetracker.interfaces;

import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Status;

/**
 * @author theparf
 *
 */
public interface IStatusDAO {
	/**
	 * 
	 * @return List of existing statuses.
	 */
	public List<Status> getListStatus();
	/**
	 * 
	 * @param id Unique object identifier.
	 * @return Object class Status.
	 */
	public Status getStatus(int id);
}
