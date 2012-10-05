package org.training.kparfiankou.issuetracker.beans;

import java.util.Date;
import java.util.List;

/**
 * @author Kiryl_Parfiankou
 *
 */
public class Issue extends AbstractEntity{
	
	private String summary;
	private String description;
	private Status status;
	private Type type;
	private Priority priority;
	private Project project;
	private Build build;
	private User assignee;
	private Date creatdate;
	private User creater;
	private Date modifyDate;
	private User lastModifier;
	private Resoplution resolution;
	private List<Comment> comments;
	
	/**
	 * @param id
	 */
	public Issue(long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	/**
	 * @return the priority
	 */
	public Priority getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}
	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	/**
	 * @return the build
	 */
	public Build getBuild() {
		return build;
	}
	/**
	 * @param build the build to set
	 */
	public void setBuild(Build build) {
		this.build = build;
	}
	/**
	 * @return the assignee
	 */
	public User getAssignee() {
		return assignee;
	}
	/**
	 * @param assignee the assignee to set
	 */
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	/**
	 * @return the creatdate
	 */
	public Date getCreatdate() {
		return creatdate;
	}
	/**
	 * @param creatdate the creatdate to set
	 */
	public void setCreatdate(Date creatdate) {
		this.creatdate = creatdate;
	}
	/**
	 * @return the creater
	 */
	public User getCreater() {
		return creater;
	}
	/**
	 * @param creater the creater to set
	 */
	public void setCreater(User creater) {
		this.creater = creater;
	}
	/**
	 * @return the modifyDate
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * @return the lastModifier
	 */
	public User getLastModifier() {
		return lastModifier;
	}
	/**
	 * @param lastModifier the lastModifier to set
	 */
	public void setLastModifier(User lastModifier) {
		this.lastModifier = lastModifier;
	}
	/**
	 * @return the resolution
	 */
	public Resoplution getResolution() {
		return resolution;
	}
	/**
	 * @param resolution the resolution to set
	 */
	public void setResolution(Resoplution resolution) {
		this.resolution = resolution;
	}
	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
