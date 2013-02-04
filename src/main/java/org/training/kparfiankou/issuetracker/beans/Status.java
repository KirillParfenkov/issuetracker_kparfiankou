package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Entity;

/**
 * @author Kiryl_Parfiankou
 *
 */
@Entity
public class Status extends SimpleEntiry {

    /**
     * The default constructor.
     */
    public Status() {
        super();
    }

    /**
     * @param id the id to set
     */
    public Status(long id) {
        super(id);
    }

    /**
     * @param id the id to set
     * @param name the name to set
     */
    public Status(long id, String name) {
        super(id, name);
    }
}