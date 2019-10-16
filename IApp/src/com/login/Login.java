package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Cookie cookie = new Cookie("root", password);
		response.addCookie(cookie);

		if (email.equals("andreea@gmail.com") && password.equals("root")) {
			response.getWriter().println("^^ GOOD ");
		} else {
			response.getWriter().println("good to know ");
		}
	}

}
