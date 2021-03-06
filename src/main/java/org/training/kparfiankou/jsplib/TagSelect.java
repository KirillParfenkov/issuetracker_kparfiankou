package org.training.kparfiankou.jsplib;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.training.kparfiankou.issuetracker.beans.AbstractEntity;

/**
 * @author parf
 *
 */
public class TagSelect extends AbstractBodyCustomTag {

	private static final long serialVersionUID = 1L;

	private String elements;
	private String id;
	private String name;
	private int selectedId;

	/**
	 * @param name the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param id the id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param selectedId the selectedId to set.
	 */
	public void setSelectedId(String selectedId) {
		this.selectedId = Integer.valueOf(selectedId);
	}

	/**
	 * @param elements the list of elements to set.
	 */
	public void setElements(String elements) {
		this.elements = elements;
	}

	private String getParams() {

		StringBuffer params = new StringBuffer();

		if  (id != null) {
			params.append(" id=");
			params.append(id);
		}
		params.append(" name=");
		params.append(name);

		return params.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int doStartTag() {

		List<AbstractEntity> list;
		try {

			list = (List<AbstractEntity>) searchElement(elements);
			JspWriter out = pageContext.getOut();

			if (list != null) {

				out.println("<select " + getParams() + ">");
				for (AbstractEntity element: list) {

					if (selectedId == element.getId()) {
						out.print("<option selected value=" + element.getId() + ">");
					} else {
						out.print("<option value=" + element.getId() + ">");
					}
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