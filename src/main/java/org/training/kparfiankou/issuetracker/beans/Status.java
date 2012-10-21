package org.training.kparfiankou.issuetracker.beans;

/**
 * @author Kiryl_Parfiankou
 *
 */
public class Status extends AbstractEntity{
	
	private String name;
	
	/**
	 * @param id
	 */
	public Status(long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	
	public String toString() {
		return name;
	}

	/**
	 * @param id
	 * @param name
	 */
	public Status(long id, String name) {
		super(id);
		this.name = name;
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
