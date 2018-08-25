package com.capgemini.ams.ui;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.capgemini.ams.bean.AssetDetailsBean;
import com.capgemini.ams.bean.UserBean;
import com.capgemini.ams.exception.AMSException;
import com.capgemini.ams.service.AssetService;
import com.capgemini.ams.service.IAssetService;

public class AssetClient {
	
	static IAssetService service=null;
	

	public static void main(String[] args) throws AMSException, IOException {

		Scanner scanner = new Scanner(System.in);
		//DISPLAYING MENU
		System.out.println("*****************************************");
		System.out.println("\tAsset Management System");
		System.out.println("*****************************************");
		System.out.println();
		System.out.println("1. Manager Login");
		System.out.println("2. Admin Login");
		int option=scanner.nextInt();
		System.out.println("Enter UserId");
		String userId=scanner.next();
		System.out.println("Enter Password");
		String password=scanner.next();
		
		service=new AssetService();
		int status=0;
		
		status=service.authenticateUser(userId, password,option);
		if(status==1){
			System.out.println("User Successfully Loged In");
			Manager();
		}else if(status==2){
			System.out.println("Admin Successfully Loged In");
			Admin();
		}else if(status==0){
			System.out.println("Please Check UserID and Password ");
		}
		
		
			
	}
	
	
	public static void Manager() throws AMSException{
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("1. Raise a Request for asset");
		System.out.println("2. Status of Request");
		System.out.println("3. Exit");
		int choice=scanner.nextInt();
		switch (choice) {
		case 1:
				
				
			break;

		case 2:
			
			break;
		case 3:
			System.exit(0);
			break;

		default:
			break;
		}
		
	}
	
	public static void Admin() throws AMSException, IOException{
		
		
		Scanner scanner = new Scanner(System.in); 
		System.out.println();
		System.out.println("1. INSERT/MODIFY Asset Details");
		System.out.println("2. Assign the Asset");
		System.out.println("3. Display Allocation Details");
		System.out.println("4. Export to Excel Sheet");
		System.out.println("5. Exit");
		int choice1=scanner.nextInt();
		switch (choice1) {
		case 1:
			
			System.out.println();
			System.out.println("1. Insert Asset Details");
			System.out.println("2. Modify Asset Details");
			int option=scanner.nextInt();
			//Insert new Asset Details
					if(option==1){
							System.out.println("Enter Asset Id");
							int assetId=scanner.nextInt();
							System.out.println("Enter Asset Name");
							String assetName=scanner.nextLine();
							System.out.println("Enter Asset Description");
							String assetDescription=scanner.nextLine();
							System.out.println("Enter Asset Quantity");
							int quantity=scanner.nextInt();
							System.out.println("Enter Status");
							String status=scanner.nextLine();
				
				
							AssetDetailsBean assetDetails=new AssetDetailsBean(assetId, assetName, assetDescription, quantity, status);
							service=new AssetService();
				
							service.addAssetDetails(assetDetails);
				
				
					}
			 //Modify Asset Details
					else if(option==2){
							System.out.println("Enter Asset Id");
							int assetId=scanner.nextInt();
							System.out.println("Enter Asset Name");
							String assetName=scanner.nextLine();
							System.out.println("Enter Asset Description");
							String assetDescription=scanner.nextLine();
							System.out.println("Enter Asset Quantity");
							int quantity=scanner.nextInt();
							System.out.println("Enter Status");
							String status=scanner.nextLine();
				
				
							AssetDetailsBean assetDetails=new AssetDetailsBean(assetId, assetName, assetDescription, quantity, status);
							service=new AssetService();
				
							service.modifyAssetDetails(assetDetails);
				
				
					}
			break;

		case 2:
			
			break;
		case 3:
			
			break;

		case 4:
			
			break;
		case 5:
			System.exit(0);
			break;

		default:
			break;
		}
	}

}

