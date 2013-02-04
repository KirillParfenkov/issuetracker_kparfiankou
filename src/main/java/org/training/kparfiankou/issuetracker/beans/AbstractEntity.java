package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.*;

/**
 * @author Kiryl_Parfiankou
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


    /**
     *  The default constructor.
     */
    public AbstractEntity() {
        super();
    }

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