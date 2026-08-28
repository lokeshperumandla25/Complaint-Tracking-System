package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.ResidentDao;
import com.model.Resident;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
 		
		Resident rs= new Resident(username,password);
		
		ResidentDao residentDao= new ResidentDao();
		Resident resident = residentDao.isValid(rs);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("resId", resident.getResId());
		session.setAttribute("username", resident.getName());
		session.setAttribute("email", resident.getEmail());
		session.setAttribute("role", resident.getRole());
		
		if(resident != null) {
			if(resident.getRole().equals("admin")) {
				resp.sendRedirect("adminDashboard.jsp");
			}
			else if(resident.getRole().equals("user")){
				resp.sendRedirect("residentDashboard.jsp");
				
			}
		}
		else {
			request.getRequestDispatcher("index.html").forward(request, resp);
		}
	
	}

}
