package com.codingdojo.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class greatNumberGame
 */
@WebServlet("/")
public class greatNumberGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public greatNumberGame() {
//        super();
        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		instantiate user session by asking our request to get the session 
		HttpSession session = request.getSession();
//		if session equals nothing
		if(session.getAttribute("randomNumber") == null) {
//			create random number
			Random rand = new Random();
			int randomNumber = rand.nextInt(100)+1;
//			set session
			session.setAttribute("randomNumber", randomNumber);
//			set model for view
			request.setAttribute("randomNumber", randomNumber);
		}
//		let view handle the request
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session = request.getSession();
//		if num not equal nothing
		if(request.getParameter("num") != null) {
//			num would be the num that user post
			int num = Integer.parseInt(request.getParameter("num"));
//			set num in session
			session.setAttribute("num", num);
		} else {
//			reset sessions
			session.setAttribute("num", null);
			session.setAttribute("randomNumber", null);
		}
		
		response.sendRedirect("/greatNumberGame");
	}

}
