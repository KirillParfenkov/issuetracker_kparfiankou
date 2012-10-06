/**
 * 
 */
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
	public List<Resolution> getListResolution();
	/**
	 * 
	 * @param id Unique object identifier.
	 * @return Object of class Resolution.
	 */
	public Resolution getResolution(int id);
}
