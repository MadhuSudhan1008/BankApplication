package com.company.bank.data.user;

import java.util.ArrayList;

import BankStatement.BankStatement;
import HelpandSupport.HelpandSupport;

public class User {
	public String UserName;
	public double UserBalanceAmount;
	public String Userpassword;
	public String Location;
	public String Branch;
	public String Role;
	public ArrayList <BankStatement> bankStatement = new ArrayList<>();
	private ArrayList<HelpandSupport> helpAndSupport = new ArrayList<>();
	public User(String userName, double userBalanceAmount, String userpassword, String location, String branch,
			String role) {
		UserName = userName;
		UserBalanceAmount = userBalanceAmount;
		Userpassword = userpassword;
		Location = location;
		Branch = branch;
		Role = role;
	}
	public User(String UserName,String Userpassword) {
		this.UserName=UserName;
		this.Userpassword=Userpassword;
		
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public double getUserBalanceAmount() {
		return UserBalanceAmount;
	}
	public void setUserBalanceAmount(double userBalanceAmount) {
		UserBalanceAmount = userBalanceAmount;
	}
	public String getUserpassword() {
		return Userpassword;
	}
	public void setUserpassword(String userpassword) {
		Userpassword = userpassword;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public ArrayList<BankStatement>getBankStatement(){
		return bankStatement;
	}
	public void addBankStatement(BankStatement statement) {
		bankStatement.add(statement);
	}
	public ArrayList<HelpandSupport> getHelpAndSupport() {
		return helpAndSupport;
	}
	public void addHelpAndSupport(HelpandSupport helpandSupport) {
		helpAndSupport.add(helpandSupport);
	}
	
	
	
}
