package com.capgemini.ams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.capgemini.ams.bean.AssetDetailsBean;
import com.capgemini.ams.exception.AMSException;
import com.capgemini.ams.ui.AssetClient;

public class AssetDAO implements IAssetDAO{
	
	int flag = 0;
    Connection connection=null;

    //To validate the user
	public int authenticateUser(String userId, String password,int option) throws AMSException {
		
		String usertype=null;
		if(option==1){
			usertype="M";
		}
		else if(option==2){
			usertype="A";
		}
		 try {
			 	connection = DBUtil.establishConnection();
		        PreparedStatement preparedStatement = connection.prepareStatement(IQueryMapper.AUTHENTICATE_USER);
		        preparedStatement.setString(1, usertype);
		        preparedStatement.setString(2, userId);
		        ResultSet results = preparedStatement.executeQuery();
		        
		        
		        while (results.next()) {
		        String userid = results.getString(1);
		        String passwrd =  results.getString(2);
		      
		           if ((userId.equals(userid)) && (password.equals(passwrd)) && (usertype.equals("M"))) {
		              flag = 1;
		              return flag;
		           }
		           else if ((userId.equals(userid)) && (password.equals(passwrd)) && (usertype.equals("A"))) {
			          flag = 2;
			          return flag;
			       }
		      }
		        
		      results.close();
		      }catch(SQLException e) {
		    	throw new AMSException("User Not Authenticated");
		    }
		return flag;
	}

	
	
	//To add asset Details
	public int addAssetDetails(AssetDetailsBean assetDetails) throws AMSException{
		
		try {
			connection = DBUtil.establishConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(IQueryMapper.INSERT_DETAILS);
			preparedStatement.setInt(1, assetDetails.getAssetId());
			preparedStatement.setString(2, assetDetails.getAssetName());
			preparedStatement.setString(3, assetDetails.getAssetDescription());
			preparedStatement.setInt(4, assetDetails.getQuantity());
			preparedStatement.setString(5, assetDetails.getStatus());
			int insertUpdate=preparedStatement.executeUpdate();
			
			System.out.println(insertUpdate+" Asset added");
			
		} catch (SQLException e) {
			throw new AMSException("Asset Details Not inserted");
		}
		
		
		
		return 0;
		
		
	}



	public int modifyAssetDetails(AssetDetailsBean assetDetails) throws AMSException{
		
		try {
			connection = DBUtil.establishConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(IQueryMapper.MODIFY_DETAILS);
			preparedStatement.setString(1, assetDetails.getAssetName());
			preparedStatement.setString(2, assetDetails.getAssetDescription());
			preparedStatement.setInt(3, assetDetails.getQuantity());
			preparedStatement.setString(4, assetDetails.getStatus());
			preparedStatement.setInt(5, assetDetails.getAssetId());
			int modifyUpdate=preparedStatement.executeUpdate();
			
			System.out.println(modifyUpdate+" Asset modified");
			
		}catch(Exception e){
			throw new AMSException("Asset Details Not modified");
		}
		return 0;
	}
	
	
}
