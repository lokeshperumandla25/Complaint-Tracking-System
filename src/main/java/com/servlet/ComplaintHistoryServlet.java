package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.dao.ComplaintDao;
import com.model.Complaint;

@WebServlet("/ComplaintHistory")
public class ComplaintHistoryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComplaintDao complaintDao= new ComplaintDao();
		
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("resId");
		
		List<Complaint> complaints = complaintDao.getSolvedComplaints(id,"resolved");
		request.setAttribute("complaints", complaints);
		request.getRequestDispatcher("complaintHistory.jsp").forward(request, response);	
		
	
	}

}
