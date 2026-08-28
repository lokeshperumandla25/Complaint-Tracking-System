package com.servlet;

import java.io.IOException;
import java.util.List;

import com.dao.AdminDao;
import com.model.Complaint;

import jakarta .servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/adminViewComplaint")
public class AdminViewComplaintServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDao adminDao= new AdminDao();
		
		List<Complaint> complaints = adminDao.getAllComplaints();
		request.setAttribute("complaints", complaints);
		request.getRequestDispatcher("adminViewComplaint.jsp").forward(request, response);	
		
	}

}
