package org.training.kparfiankou.issuetracker.beans;

/**
 * @author Kiryl_Parfiankou
 *
 */
public class Build extends AbstractEntity {

	private String name;

	/**
	 * @param id The id to set
	 */
	public Build(long id) {
		super(id);
	}

	/**
	 * @param id The id to set
	 * @param name The name to set
	 */
	public Build(long id, String name) {
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