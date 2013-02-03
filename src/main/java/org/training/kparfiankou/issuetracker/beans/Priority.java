package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Kiryl_Parfiankou
 *
 */
@Entity
@Table(name = "Priorities")
public class Priority extends AbstractEntity {

	private String name;

	/**
	 * The default constructor.
	 */
	public Priority() {
	}

	/**
	 *
	 * @param id the id to set
	 */
	public Priority(long id) {
		super(id);
	}

	/**
	 *
	 * @param id The id to set
	 * @param name The name to set
	 */
	public Priority(long id, String name) {
		super(id);
		this.name = name;
	}

	/**
	 * @return String
	 */
	public String toString() {
		return name;
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
}