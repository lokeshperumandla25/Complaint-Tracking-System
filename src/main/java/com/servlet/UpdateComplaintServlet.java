package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.ComplaintDao;
import com.model.Complaint;


@WebServlet("/UpdateComplaint")
public class UpdateComplaintServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComplaintDao complaintDao= new ComplaintDao();
		
		int complaintId = Integer.parseInt(request.getParameter("Complaintid"));
		Complaint complaint = complaintDao.getComplaintById(complaintId);
		//System.out.println(complaintId);
		//System.out.println(complaint);
		
		request.setAttribute("complaint", complaint);
		request.getRequestDispatcher("updateComplaint.jsp").forward(request, response);
		
	}

}
