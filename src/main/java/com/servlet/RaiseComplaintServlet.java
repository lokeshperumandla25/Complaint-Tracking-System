package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.ComplaintDao;
import com.model.Complaint;

@WebServlet("/RaiseComplaint")
public class RaiseComplaintServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComplaintDao complaintDao= new ComplaintDao();
		
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("resId");
		String category = request.getParameter("category");
		String subject = request.getParameter("subject");
		String description = request.getParameter("description");
		String status="pending";
		Complaint complaint= new Complaint(id,category,subject,description,status);
		
		complaintDao.saveComplaint(complaint);
		response.sendRedirect("residentViewComplaint");
	}

}
