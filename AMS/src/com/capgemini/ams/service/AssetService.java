package com.capgemini.ams.service;

import com.capgemini.ams.bean.AssetDetailsBean;
import com.capgemini.ams.dao.AssetDAO;
import com.capgemini.ams.dao.IAssetDAO;
import com.capgemini.ams.exception.AMSException;

public class AssetService implements IAssetService{
	
	IAssetDAO assetdao=null;
	public int authenticateUser(String userId,String password,int option) throws AMSException {
		
		assetdao=new AssetDAO();
		
		return assetdao.authenticateUser(userId,password,option);
		
	}
	
	public int addAssetDetails(AssetDetailsBean assetDetails) throws AMSException{
		
		assetdao=new AssetDAO();
		
		return assetdao.addAssetDetails(assetDetails);
	}

	
	public int modifyAssetDetails(AssetDetailsBean assetDetails) throws AMSException{
		
		assetdao=new AssetDAO();
		
		return assetdao.modifyAssetDetails(assetDetails);
	}

}
