package org.training.kparfiankou.jsplib;

import javax.servlet.jsp.tagext.BodyTagSupport;

import org.training.kparfiankou.issuetracker.beans.Role;
import org.training.kparfiankou.issuetracker.beans.User;

/**
 *
 * @author parf
 *
 */
public class TagAdministrator extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() {

		TagContextUser context =  (TagContextUser) findAncestorWithClass(this, TagContextUser.class);
		User user = context.getUserObject();

		if (user != null) {
			if (Role.ADMINISTRATOR.equals(user.getRole())) {
				return EVAL_BODY_INCLUDE;
			}
		}
		return SKIP_BODY;
	}
}