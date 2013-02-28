package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Entity;

/**
 * @author Kiryl_Parfiankou
 *
 */
@Entity
public class Type extends SimpleEntiry {

    /**
     * The default constructor.
     */
    public Type() {
        super();
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