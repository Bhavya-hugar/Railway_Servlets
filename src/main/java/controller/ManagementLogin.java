package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/managementlogin")
public class ManagementLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		if (email.equals("admin")) {
			if (password.equals("admin")) {
				resp.getWriter().print("<h1 style='color:red'>login successful</h1>");
				req.getRequestDispatcher("ManagementHome.html").include(req, resp);
			} else {
				resp.getWriter().print("<h1 style='color:red'>invalid password</h1>");
				req.getRequestDispatcher("ManagementLogin.html").include(req, resp);
			}

		} else {

			resp.getWriter().print("<h1 style='color:red'>invalid email</h1>");
			req.getRequestDispatcher("ManagementLogin.html").include(req, resp);
		}
	}
}
