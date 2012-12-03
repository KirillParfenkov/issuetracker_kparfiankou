package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.kparfiankou.issuetracker.Constants;

/**
 * AbstractController implementation class CreateResolutionAddingPage.
 */
public class CreateResolutionAddingPage extends AbstractController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateResolutionAddingPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		jump(Constants.ADDING_RESOLUTION_PAGE, request, response);
	}
}