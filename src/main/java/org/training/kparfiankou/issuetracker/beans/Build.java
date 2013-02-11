package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Kiryl_Parfiankou
 *
 */
@Entity
public class Build extends SimpleEntiry {

   /* @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;        */

    /**
     * The default constructor.
     */
    public Build() {
    }

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
        super(id,name);
    }
}