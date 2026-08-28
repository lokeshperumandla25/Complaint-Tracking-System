package com.util;

public class Constants {
	
	public static final String URL="jdbc:mysql://localhost:3306/miniproject3";
	public static final String USERNAME ="root";
	public static final String PASSWORD ="Root_123";
	public static final String Get_User="SELECT * FROM USER WHERE name=?";
	public static final String INSERT_USER= "Insert into User(name,email,password,role) values(?,?,?,?)";
	public static final String GET_COMPLAINTS="SELECT * FROM COMPLAINT WHERE userId=?";
	public static final String INSERT_COMPLAINT="INSERT INTO COMPLAINT(USERID,CATEGORY,SUBJECT,DESCRIPTION,STATUS) VALUES(?,?,?,?,?)";
	public static final String GET_SOLVED_COMPLAINTS="SELECT * FROM COMPLAINT WHERE userId=? and status=?";
	public static final String GET_COMPLAINT="SELECT * FROM COMPLAINT WHERE COMPLAINTID=?";
	public static final String UPDATE_COMPLAINT="UPDATE COMPLAINT SET CATEGORY=? ,SUBJECT=? ,DESCRIPTION=? WHERE COMPLAINTID=?";
	public static final String DELETE_COMPLAINT="DELETE FROM COMPLAINT WHERE COMPLAINTID=?";
	public static final String GET_ALL_COMPLAINTS="SELECT * FROM COMPLAINT";
	public static final String UPDATE_STATUS="UPDATE COMPLAINT SET STATUS=? WHERE COMPLAINTID=?";
}
