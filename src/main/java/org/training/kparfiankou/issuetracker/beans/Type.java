package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author Kiryl_Parfiankou
 *
 */

@Entity
@Table(name="Types")
public class Type extends SimpleEntiry {

	/**
	 * The default constructor.
	 */
	public Type() {
	}

	/**
	 * @param id the id to set
	 */
	public Type(long id) {
		super(id);
	}

	/**
	 * @param id the id to set
	 * @param name the name to set
	 */
	public Type(long id, String name) {
		super(id, name);
	}
}