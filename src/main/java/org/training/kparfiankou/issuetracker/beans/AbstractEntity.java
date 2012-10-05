package org.training.kparfiankou.issuetracker.beans;

/**
 * @author Kiryl_Parfiankou
 *
 */
abstract public class AbstractEntity {
	private long id;
	
	/**
	 * @param id
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
