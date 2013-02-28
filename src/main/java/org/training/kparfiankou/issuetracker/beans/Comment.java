package org.training.kparfiankou.issuetracker.beans;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Kiryl_Parfiankou
 *
 */
@Entity
public class Comment extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "issue_id")
    private Issue issue;
    @ManyToOne
	private User autor;
	private Date addDate;
	private String content;

    /**
     * Default constructor.
     */
    public Comment() {
        super();
    }

	/**
	 * @param id The id to set
	 */
	public Comment(long id) {
		super(id);
	}

	/**
	 * @param id The id to set
	 * @param autor The autor to set
	 * @param addDate The addDate to set
	 * @param content The content to set
	 */
	public Comment(long id, User autor, Date addDate, String content) {
		super(id);
		this.autor = autor;
		this.addDate = addDate;
		this.content = content;
	}

	/**
	 * @return the autor
	 */
	public User getAutor() {
		return autor;
	}
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(User autor) {
		this.autor = autor;
	}
	/**
	 * @return the addDate
	 */
	public Date getAddDate() {
		return addDate;
	}
	/**
	 * @param addDate the addDate to set
	 */
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Issue getIssue() {
        return issue;
    }
}