package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.ComplaintDao;
 
@WebServlet("/DeleteComplaint")
public class DeleteComplaintServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt( request.getParameter("Complaintid"));
		
		//System.out.println(id);
		ComplaintDao complaintDao= new ComplaintDao();
		complaintDao.deleteComplaint(id);
		
		response.sendRedirect("residentViewComplaint");
		
	}

}
