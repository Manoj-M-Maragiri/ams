package com.capgemini.ams.bean;

public class AssetDetailsBean {
	
	private int assetId;
	private String assetName;
	private String assetDescription;
	private int quantity;
	private String status;
	public String getAssetDescription() {
		return assetDescription;
	}
	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public AssetDetailsBean(){
		
	}
	public AssetDetailsBean(int assetId,String assetName, String assetDescription,
			int quantity, String status) {
		this.assetId = assetId;
		this.assetName = assetName;
		this.assetDescription = assetDescription;
		this.quantity = quantity;
		this.status = status;
	}

	
	
	
}
