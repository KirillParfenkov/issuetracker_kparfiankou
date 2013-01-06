package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



/**
 * @author Kiryl_Parfiankou
 *
 */


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractEntity {
	@Id
	@Column(name="id")
	private long id;
	
	/**
	 * The default constructor
	 */
	public AbstractEntity() {}

	/**
	 * @param id The id to set
	 */
	public AbstractEntity(long id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
}