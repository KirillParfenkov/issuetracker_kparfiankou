package org.training.kparfiankou.issuetracker.dao;

import java.util.List;

import org.training.kparfiankou.issuetracker.beans.Build;
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
     *
     * @param build
     */
    void insertBuild(Build build);

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

    /**
     * @return max index.
     */
    long getMaxIndex();
}