package org.training.kparfiankou.issuetracker.beans;

/**
 * @author Kiryl_Parfiankou
 *
 */
public class Resoplution extends AbstractEntity{
	
	private String name;
	
	/**
	 * @param id
	 */
	public Resoplution(long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param name
	 */
	public Resoplution(long id, String name) {
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
