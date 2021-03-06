package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kiryl_Parfiankou
 *
 */
@Entity
public class Project extends AbstractEntity {

    @Column(name = "name")
	private String name;
    @Column(name = "description")
	private String description;
    @OneToMany(cascade = CascadeType.ALL)
	private List<Build> builds;
    @ManyToOne
    @JoinTable(name = "project_manager")
	private User manager;


    /**
     * Default constructor.
     */
    public Project() {
        super();
        builds = new ArrayList<Build>();
    }

	/**
	 * @param id the id to set
	 */
	public Project(long id) {
		super(id);
		builds = new ArrayList<Build>();
	}

	/**
	 * @param id the id to set
	 * @param name the name to set
	 * @param manager the manager to set
	 */
	public Project(int id, String name,
			User manager) {
		super(id);
		builds = new ArrayList<Build>();

		this.name = name;
		this.manager = manager;
	}

	@Override
	public String toString() {
		return name;
	}

	/**
	 * @param build the build to set
	 */
	public void addBuild(Build build) {
		builds.add(build);
	}
	/**
	 * @return the build
	 * @param id the id of build
	 */
	public Build getBuild(int id) {

		for (Build build: builds) {
			if (build.getId() == id) {
				return build;
			}
		}
		return null;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the builds
	 */
	public List<Build> getBuilds() {
		return builds;
	}
	/**
	 * @param builds the builds to set
	 */
	public void setBuilds(List<Build> builds) {
		this.builds = builds;
	}
	/**
	 * @return the manager
	 */
	public User getManager() {
		return manager;
	}
	/**
	 * @param manager the manager to set
	 */
	public void setManager(User manager) {
		this.manager = manager;
	}
}