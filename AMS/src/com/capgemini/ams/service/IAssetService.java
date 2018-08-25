package com.capgemini.ams.service;


import com.capgemini.ams.bean.AssetDetailsBean;
import com.capgemini.ams.exception.AMSException;

public interface IAssetService {
	
	public abstract int authenticateUser(String userID,String password,int option) throws AMSException;

	public abstract int addAssetDetails(AssetDetailsBean assetDetails) throws AMSException;

	public abstract int modifyAssetDetails(AssetDetailsBean assetDetails) throws AMSException;

}