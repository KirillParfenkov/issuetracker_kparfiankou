package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Entity;

/**
 * @author Kiryl_Parfiankou
 *
 */
@Entity
public class Resolution extends SimpleEntiry {


    /**
     * Default constructor.
     */
    public Resolution() {
        super();
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
		super(id, name);
	}

}