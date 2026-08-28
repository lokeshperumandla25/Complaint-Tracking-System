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

public class AdminDao {
	
	public List<Complaint> getAllComplaints(){
		List<Complaint> list = new ArrayList<Complaint>() ;
		
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.GET_ALL_COMPLAINTS);
						
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
	
	public void updateStatus(int id,String status) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_STATUS);
			
			statement.setString(1, status);
			statement.setInt(2, id);
			
			statement.executeUpdate();
					
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
