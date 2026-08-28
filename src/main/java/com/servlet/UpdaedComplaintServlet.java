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


@WebServlet("/UpdatedComplaint")
public class UpdaedComplaintServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComplaintDao complaintDao= new ComplaintDao();
		
		int comId = Integer.parseInt(request.getParameter("complaintId"));
		int resId = Integer.parseInt(request.getParameter("userId"));
		String category = request.getParameter("category");
		String subject = request.getParameter("subject");
		String description = request.getParameter("description");
		String status = request.getParameter("status");

		Complaint complaint = new Complaint(comId,resId,category,subject,description,status);
		complaintDao.updateComplaint(complaint);
		
		response.sendRedirect("residentViewComplaint");
		
	}

}
