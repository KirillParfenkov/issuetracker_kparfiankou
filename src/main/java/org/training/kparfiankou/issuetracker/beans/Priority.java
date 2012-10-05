package org.training.kparfiankou.issuetracker.beans;

/**
 * @author Kiryl_Parfiankou
 *
 */
public class Priority extends AbstractEntity{
	
	private String name;

	public Priority(long id) {
		super(id);
	}
	
	public Priority(long id, String name) {
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
