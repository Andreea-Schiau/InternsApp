package com.user.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.dao.impl.UserDaoServiceImpl;
import com.DB.model.User;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDaoServiceImpl userDaoImpl = new UserDaoServiceImpl();
		User user = new User(email, password);
		
		if (userDaoImpl.insert(user)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("logged.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}
}

