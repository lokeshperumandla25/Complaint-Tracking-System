package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.AdminDao;


@WebServlet("/UpdateStatus")
public class UpdateStatusServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao dao= new AdminDao();
		int id=Integer.parseInt(request.getParameter("complaintId"));
		String status= request.getParameter("status");
		
		dao.updateStatus(id,status);
		request.getRequestDispatcher("adminViewComplaint").forward(request, response);
		
	}

}
