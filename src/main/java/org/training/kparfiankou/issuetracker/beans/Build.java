package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Kiryl_Parfiankou
 *
 */
@Entity
@Table(name = "Builds")
public class Build extends SimpleEntiry {

	/**
	 * The default constructor. 
	 */
	public Build() {
	}

	/**
	 * @param id The id to set
	 */
	public Build(long id) {
		super(id);
	}

	/**
	 * @param id The id to set
	 * @param name The name to set
	 */
	public Build(long id, String name) {
		super(id,name);
	}
}