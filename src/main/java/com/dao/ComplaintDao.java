package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Complaint;
import com.util.Constants;
import com.util.DBConnection;

public class ComplaintDao {

	public List<Complaint> getComplaints(int id){
		List<Complaint> list = new ArrayList<Complaint>() ;
		
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.GET_COMPLAINTS);
			
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int complaintId = rs.getInt(1);
				int userId = rs.getInt(2);
				String category= rs.getString(3);
				String subject = rs.getString(4);
				String description = rs.getString(5);
				String status = rs.getString(6);	
				
				Complaint complaint = new Complaint(complaintId,userId,category,subject,description,status);
				list.add(complaint);
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public void saveComplaint(Complaint complaint) {
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.INSERT_COMPLAINT);
			statement.setInt(1, complaint.getUserId());
			statement.setString(2, complaint.getCategory());
			statement.setString(3, complaint.getSubject());
			statement.setString(4, complaint.getDescription());
			statement.setString(5, complaint.getStatus());
			
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Complaint> getSolvedComplaints(int id,String stat){
		List<Complaint> list = new ArrayList<Complaint>() ;
		
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.GET_SOLVED_COMPLAINTS);
			
			statement.setInt(1, id);
			statement.setString(2, stat);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int complaintId = rs.getInt(1);
				int userId = rs.getInt(2);
				String category= rs.getString(3);
				String subject = rs.getString(4);
				String description = rs.getString(5);
				String status = rs.getString(6);	
				
				Complaint complaint = new Complaint(complaintId,userId,category,subject,description,status);
				list.add(complaint);
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public Complaint getComplaintById(int complaintId) {
		Complaint complaint = null;
		try {
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(Constants.GET_COMPLAINT);
		
		statement.setInt(1, complaintId);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			int Id = rs.getInt(1);
			int userId = rs.getInt(2);
			String category= rs.getString(3);
			String subject = rs.getString(4);
			String description = rs.getString(5);
			String status = rs.getString(6);	
			
			complaint = new Complaint(Id,userId,category,subject,description,status);
		}
		
		

		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return complaint;
	}
	
	public void updateComplaint(Complaint complaint) {
		Connection connection;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_COMPLAINT);
			
			statement.setString(1 , complaint.getCategory());
			statement.setString(2, complaint.getSubject());
			statement.setString(3, complaint.getDescription());
			statement.setInt(4, complaint.getComplaintId());
			
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public void deleteComplaint(int id) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.DELETE_COMPLAINT);
			
			statement.setInt(1, id);
			statement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
