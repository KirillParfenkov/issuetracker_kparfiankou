package org.training.kparfiankou.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AbstractController.
 */
public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbstractController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the ServletException
	 * @throws IOException the IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the ServletException
	 * @throws IOException the IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	/**
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the ServletException
	 * @throws IOException the IOException
	 */
	protected abstract void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	/**
	 *
	 * @param url the url
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the ServletException
	 * @throws IOException the IOException
	 */
	protected void jump(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
	    rd.forward(request, response);
	}
}