package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Kiryl_Parfiankou
 *
 */
@Entity
@Table(name = "Resolutions")
public class Resolution extends AbstractEntity {

	private String name;

	/**
	 * The default constructor.
	 */
	public Resolution() {
	}

	/**
	 * @param id The id to set
	 */
	public Resolution(long id) {
		super(id);
	}

	/**
	 * @param id The id to set
	 * @param name The name to set
	 */
	public Resolution(long id, String name) {
		super(id);
		this.name = name;
	}

	@Override
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