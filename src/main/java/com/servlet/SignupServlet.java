package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.ResidentDao;
import com.model.Resident;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
 		
		Resident rs= new Resident(username,email,password,role);
		
		ResidentDao residentDao= new ResidentDao();
		residentDao.saveResident(rs);
		
		request.getRequestDispatcher("index.html").forward(request, response);
	
	}
	}