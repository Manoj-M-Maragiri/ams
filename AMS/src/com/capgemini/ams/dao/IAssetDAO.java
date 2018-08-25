package com.capgemini.ams.dao;

import com.capgemini.ams.bean.AssetDetailsBean;
import com.capgemini.ams.exception.AMSException;

public interface IAssetDAO {
	

	abstract public int authenticateUser(String userID,String password,int option) throws AMSException;

	abstract public int addAssetDetails(AssetDetailsBean assetDetails) throws AMSException;

	abstract public int modifyAssetDetails(AssetDetailsBean assetDetails) throws AMSException;
	
}