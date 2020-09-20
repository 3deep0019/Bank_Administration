package controller;


import java.util.Scanner;

import Utility.Verification;
import service.Bank_Admin_Operation;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Bank_Admin_Operation BAO = new Bank_Admin_Operation();
		System.out.println("\t<<<<<<<...........BANK ADMINISTRATION...........>>>>>>>");
		boolean result=false;
		Verification veri = new Verification();
		// validating entered detail
		while(result==false) {
			
			System.out.println(">>>> Login as Admin");
			System.out.println("Enter your Username :");
			String Username=sc.nextLine();
			System.out.println("Enter your Password :");
			String Password=sc.nextLine();
			
			if(veri.verifyLogin(Username,Password)){
				System.out.println("Your Access is granted !!!! \n\n");
				BAO.BankAdminOp();
				result=true;
			}
			else {
				System.out.println("Entered Detail is wrong...please check again..... ");
				
			}
		}
		
		

		
	}

}
