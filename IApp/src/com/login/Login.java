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

		if (email.equals("andreea@gmail.com") && password.equals("root")) {

			request.setAttribute("email", email);
			request.getRequestDispatcher("logged.jsp").forward(request, response);

		} else {

			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}

	}

}
