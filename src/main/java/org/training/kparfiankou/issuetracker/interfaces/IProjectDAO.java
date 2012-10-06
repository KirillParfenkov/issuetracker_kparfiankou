/**
 * 
 */
package org.training.kparfiankou.issuetracker.interfaces;

import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Project;

/**
 * @author theparf
 *
 */
public interface IProjectDAO {
	/**
	 * 
	 * @return List of existing
	 */
	public List<Project> getListProject();
	/**
	 * 
	 * @param id Unique object identifier.
	 * @return Object if class Project.
	 */
	public Project getProject(int id);
}
