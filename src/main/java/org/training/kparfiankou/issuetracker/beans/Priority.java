package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Entity;

/**
 * @author Kiryl_Parfiankou
 *
 */
@Entity
public class Priority extends SimpleEntiry {

    /**
     * Default constructor.
     */
    public Priority() {
        super();
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
		super(id, name);
	}
}