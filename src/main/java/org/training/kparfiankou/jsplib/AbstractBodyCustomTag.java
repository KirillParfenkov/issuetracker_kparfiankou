package org.training.kparfiankou.jsplib;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 *
 * @author parf
 *
 */
public abstract class AbstractBodyCustomTag extends BodyTagSupport {

	private static final long serialVersionUID = -7015964043786271260L;

	/**
	 * @param nameElement the name of element.
	 * @return Object.
	 */
	protected Object searchElement(String nameElement) {

		Object element = null;

		element = pageContext.getAttribute(nameElement, PageContext.REQUEST_SCOPE);

		if (element == null) {
			element = pageContext.getAttribute(nameElement, PageContext.PAGE_SCOPE);
		}
		if (element == null) {
			element = pageContext.getAttribute(nameElement, PageContext.SESSION_SCOPE);
		}
		if (element == null) {
			element = pageContext.getAttribute(nameElement, PageContext.APPLICATION_SCOPE);
		}

		return element;
	}
}