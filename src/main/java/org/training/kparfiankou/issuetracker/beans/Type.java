/**
 * 
 */
package org.training.kparfiankou.issuetracker.beans;

/**
 * @author Kiryl_Parfiankou
 *
 */
public class Type extends AbstractEntity{
	
	private String name;
	
	/**
	 * @param id
	 */
	public Type(long id) {
		super(id);
	}

	/**
	 * @param id
	 * @param name
	 */
	public Type(long id, String name) {
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
