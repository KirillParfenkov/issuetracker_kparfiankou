package org.training.kparfiankou.jsplib;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.training.kparfiankou.issuetracker.beans.AbstractEntity;

/**
 * @author parf
 *
 */
public class TagSelect extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	private String elements;
	private String name;

	/**
	 * @param name the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param elements the list of elements to set.
	 */
	public void setElements(String elements) {
		this.elements = elements;
	}

	@SuppressWarnings("unchecked")
	private List<AbstractEntity> searchElements() {

		List<AbstractEntity> list;

		list = (List<AbstractEntity>) pageContext.getAttribute(elements, PageContext.REQUEST_SCOPE);

		if (list == null) {
			list = (List<AbstractEntity>) pageContext.getAttribute(elements, PageContext.APPLICATION_SCOPE);
		}
		if (list == null) {
			list = (List<AbstractEntity>) pageContext.getAttribute(elements, PageContext.SESSION_SCOPE);
		}
		if (list == null) {
			list = (List<AbstractEntity>) pageContext.getAttribute(elements, PageContext.PAGE_SCOPE);
		}
		return list;
	}

	@Override
	public int doStartTag() {

		List<AbstractEntity> list;
		try {

			list = searchElements();
			JspWriter out = pageContext.getOut();

			if (list != null) {

				out.println("<select name=" + name + ">");

				for (AbstractEntity element: list) {

					out.print("<option value=" + element.getId() + ">");
					out.print(element);
					out.println("</option>");
				}
				out.println("</select>");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}