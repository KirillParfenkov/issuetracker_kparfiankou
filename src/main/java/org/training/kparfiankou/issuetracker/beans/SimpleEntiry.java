package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author parf
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class SimpleEntiry extends AbstractEntity {

    @Column(name = "name")
	private String name;

    /**
     * The default constructor.
     */
	public SimpleEntiry() {
        super();
    }

    /**
	 * @param id the id to set
	 */
	public SimpleEntiry(long id) {
		super(id);
	}

	/**
	 * @param id the id to set
	 * @param name the name to set
	 */
	public SimpleEntiry(long id, String name) {
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