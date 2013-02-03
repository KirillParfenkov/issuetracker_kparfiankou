package org.training.kparfiankou.issuetracker.interfaces;

import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Project;

/**
 * @author theparf
 *
 */
public interface IProjectDAO {

	/**
	 * @return List of existing.
	 */
	List<Project> getListProject();

	/**
	 * @param id Unique object identifier.
	 * @return Object if class Project.
	 */
	Project getProject(long id);

	/**
	 *
	 * @param project the project to be added.
	 */
	void insertProject(Project project);

	/**
	 * @param project object of class Project
	 */
	void updateProject(Project project);

	/**
	 *
	 * @param id of project.
	 */
	void removeProject(long id);

	/**
	 * Closes DAO.
	 */
	void close();
}