package com.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.user.dao.UserDAO;
import com.DB.user.dao.impl.JdbcUserDAO;
import com.DB.user.model.User;
@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginDao dao = new LoginDao();
		
		if(dao.check(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("logged.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}
}
