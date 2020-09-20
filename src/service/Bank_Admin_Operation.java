package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Utility.Verification;
import model.User;

public class Bank_Admin_Operation {
	 User user = new User();
	List<User> userlist = new ArrayList<User>();
	public void BankAdminOp(){
		Scanner sc = new Scanner(System.in);
		Verification veri = new Verification();
		boolean result=true;
		while(result == true) {
			System.out.println("what you want to do...");
			System.out.println("\t"+"1.Create new Customer record");
			System.out.println("\t"+"2.View all Customer Record");
			System.out.println("\t"+"3.View Customer record");
			System.out.println("\t"+"4.Update Customer record");
			System.out.println("\t"+"5.Delete Customer Record");
			System.out.println("\t"+"6.exit");
			User user = new User();
			ReadDetails rd = new ReadDetails();
			int choice =sc.nextInt();
			switch(choice) {
			case 1:
				//creating Customer
				System.out.println("\t<<<<<<<...........Create New Customer...........>>>>>>>");
				System.out.println("Enter the ID  of the Customer");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Name of the Customer");
				String name = sc.nextLine();
				boolean emailv = false;
				while(emailv==false) {
					System.out.println("Enter the Email of the Customer");
					String email = sc.next();
					if(veri.validEmail(email)) {
						user.setEmail(email);
						emailv=true;
					}else System.out.println("Email is not valid");
				}
				
				sc.nextLine();
				System.out.println("Enter the Address of the Customer");
				String address = sc.nextLine();
				boolean phonev = false;
				while(phonev==false) {
					System.out.println("Enter the Phone Number of the Customer");
					String ph_no = sc.nextLine();
					if(ph_no.length()==10) {
						user.setPhone_no(ph_no);
						phonev=true;
					}else System.out.println("Phone Number is not valid");
				}
				
				
				user.setId(id);
				user.setName(name);
				user.setAddress(address);
				userlist.add(user);
				Add_A_Custumer AAC = new Add_A_Custumer();
				AAC.Add_Customer(user);
				System.out.println("\n\n");
				break;
				
			case 2:
				//view data of customers
				System.out.println("\t<<<<<<<...........View all Data of Existing Customer...........>>>>>>>\n");
				
				rd.readRecord();
				

				
				break;
			case 3:
				//  View the Existing Customer
				System.out.println("\t<<<<<<<...........View the Existing Customer...........>>>>>>>");
				System.out.println("Enter the ID  of the Customer");
				int c_id = sc.nextInt();
				rd.readRecord(c_id);
				
				
				
				break;
			case  4:
				//Update the Existing Customer
				System.out.println("\t<<<<<<<...........Update the Existing Customer...........>>>>>>>");
				Modify_A_Customer MAC = new Modify_A_Customer();
				boolean update_process = false;
				while(update_process == false) {
					System.out.println("\n\n");
					System.out.println("\t"+"1.Update the Name");
					System.out.println("\t"+"2.Update the Email");
					System.out.println("\t"+"3.Update the Address");
					System.out.println("\t"+"4.Update the Phone Number");
					System.out.println("\t"+"5.exit");
					int cho = sc.nextInt();
					if(cho==5) { 
						update_process = true; 
						break;
					}
					System.out.println("Enter the ID  of the Customer");
					int cu_id = sc.nextInt();
					sc.nextLine();
					
					
						
							switch(cho) {
							case 1:
								System.out.println("Enter the New Name");
								String Name = sc.nextLine();
								MAC.Modify_Customer(cu_id, Name, cho);
								System.out.println("Name Updated \n\n");
								break;
								
							case 2:
								boolean emailverify = false;
								while(emailverify==false) {
									System.out.println("Enter the New Email");
									String Email = sc.nextLine();
									if(veri.validEmail(Email)) {
										MAC.Modify_Customer(cu_id, Email, cho);
										System.out.println("Email Updated \n\n");
										emailverify=true;
									}else System.out.println("Email is not valid\n");
								}
								
								break;
							case 3:
								System.out.println("Enter the New Address");
								String Address = sc.nextLine();
								MAC.Modify_Customer(cu_id, Address, cho);
								System.out.println("Address Updated \n\n");
								break;
							case  4:
								
								boolean phoneverify = false;
								while(phoneverify==false) {
									System.out.println("Enter the New Phone Number");
									String ph = sc.nextLine();
									if(ph.length()==10) {
										MAC.Modify_Customer(cu_id, ph, cho);
										System.out.println("Phone Number Updated \n\n");
										phoneverify=true;
									}else System.out.println("Phone Number is not valid\n");
								}
								break;				
						}

						
					
										}
					break;
			case 5:
				// Delete the Existing Customer
				System.out.println("\t<<<<<<<...........Delete the Existing Customer...........>>>>>>>");
				System.out.println("Enter the ID  of the Customer");
				int cus_id = sc.nextInt();
				Delete_A_Customer dac = new Delete_A_Customer();
				dac.deleteTheRecord(cus_id);
				break;
				
			case 6:
				// exit
				System.out.println("exit");
				result = false;
				break;
				
			
			}
		}
	}
}
