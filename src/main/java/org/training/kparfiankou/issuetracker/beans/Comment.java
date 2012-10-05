package org.training.kparfiankou.issuetracker.beans;

import java.util.Date;

/**
 * @author Kiryl_Parfiankou
 *
 */
public class Comment extends AbstractEntity{
	
	private User Autor;
	private Date addDate;
	private String content;
	
	/**
	 * @param id
	 */
	public Comment(long id) {
		super(id);
	}
	
	/**
	 * @param id
	 * @param autor
	 * @param addDate
	 * @param content
	 */
	public Comment(long id, User autor, Date addDate, String content) {
		super(id);
		Autor = autor;
		this.addDate = addDate;
		this.content = content;
	}
	
	/**
	 * @return the autor
	 */
	public User getAutor() {
		return Autor;
	}
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(User autor) {
		Autor = autor;
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
