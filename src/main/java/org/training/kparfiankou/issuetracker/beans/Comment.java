package org.training.kparfiankou.issuetracker.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Kiryl_Parfiankou
 *
 */
public class Comment extends AbstractEntity {

	private User autor;
	private Date addDate;
	private String content;

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
}