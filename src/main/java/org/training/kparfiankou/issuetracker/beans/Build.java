package org.training.kparfiankou.issuetracker.beans;

/**
 * @author Kiryl_Parfiankou
 *
 */
public class Build extends AbstractEntity{
	
	private String name;

	/**
	 * @param id
	 */
	public Build(long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param name
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
