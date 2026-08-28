package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Resident;
import com.util.Constants;
import com.util.DBConnection;

public class ResidentDao {

	public Resident isValid(Resident resident) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.Get_User);
			
			statement.setString(1, resident.getName());
			
			ResultSet resultSet = statement.executeQuery();
			String name =null;
			String password =null;
			String role= null;
			int id = 0;
			while(resultSet.next()) {
				 id=resultSet.getInt(1);
				 name = resultSet.getString(2);
				 password = resultSet.getString(4);
				 role = resultSet.getString(5);
			}
			
			if(resident.getName().equals(name) && resident.getPassword().equals(password)) {
				 resident.setResId(id);
				 resident.setName(name);
				 resident.setPassword(password);
				 resident.setRole(role);
				 
				 return resident;
			}
			else {
				return null;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resident;
		
	}
	
	public void saveResident(Resident resident) {
	Connection connection;
	try {
		connection = DBConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(Constants.INSERT_USER);
		statement.setString(1, resident.getName());
		statement.setString(2, resident.getEmail());
		statement.setString(3, resident.getPassword());
		statement.setString(4, resident.getRole());
		
		statement.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
