package com.capgemini.ams.dao;

public interface IQueryMapper {
	
	public final String AUTHENTICATE_USER="SELECT UserId,UserPassword FROM User_Master WHERE UserType=? AND UserId=?";
	
	public final String INSERT_DETAILS="INSERT INTO Asset VALUES(?,?,?,?,?)";
	
	public final String MODIFY_DETAILS="UPDATE Asset SET AssetName=?, AssetDes=?, Quantity=?, Status=? WHERE AssetId=?";
	
}