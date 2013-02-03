package org.training.kparfiankou.issuetracker.interfaces;

import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Resolution;

/**
 * @author theparf
 *
 */
public interface IResolutionDAO {
	/**
	 *
	 * @return List of possible resolutions.
	 */
	List<Resolution> getListResolution();
	/**
	 *
	 * @param id Unique object identifier.
	 * @return Object of class Resolution.
	 */
	Resolution getResolution(long id);

	/**
	 * @param nameResolution name of resolution
	 * @return Object of class Resolution
	 */
	Resolution getResolution(String nameResolution);

	/**
	 * @param resolution object of class Resolution
	 */
	void updateResolution(Resolution resolution);

	/**
	 * Close connection with Database.
	 */
	void close();

	/**
	 * @param id of resolution
	 */
	void removeResolution(long id);

	/**
	 * @param resolution object of class Resolution
	 */
	void insertResolution(Resolution resolution);

	/**
	 * @return max index;
	 */
	long getMaxIndex();
}