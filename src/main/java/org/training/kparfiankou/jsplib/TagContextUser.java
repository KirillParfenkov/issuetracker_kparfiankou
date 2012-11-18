package org.training.kparfiankou.jsplib;

import org.training.kparfiankou.issuetracker.beans.User;

/**
 *
 * @author parf
 *
 */
public class TagContextUser extends AbstractBodyCustomTag {

	private static final long serialVersionUID = 1L;

	private User userObject;

	/**
	 * @param user the user to set.
	 */
	public void setUser(String user) {
		this.userObject = (User) searchElement(user);
	}

	@Override
	public int doStartTag() {

		if (userObject != null) {
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}

	/**
	 * @return User
	 */
	public User getUserObject() {
		return userObject;
	}
}