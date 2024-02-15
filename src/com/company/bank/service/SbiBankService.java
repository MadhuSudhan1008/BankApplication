package com.company.bank.service;
import java.util.Date;
import java.util.Scanner;
import com.company.bank.data.config.AllBanksConfigData;
import com.company.bank.data.user.User;
import BankStatement.BankStatement;
import HelpandSupport.HelpandSupport;

public class SbiBankService  implements RBI{
	Scanner sc =new Scanner(System.in);
	private User userData;
	private static AllBanksConfigData configData;
	static {
		configData=new AllBanksConfigData(0.12,0.012);
	}
	
	public SbiBankService(User userData) {
		this.userData=userData;
	}
	
	public void showBalance() {
		System.out.println("Current Balance is"+userData.getUserBalanceAmount());
	}
	
	public void withdraw(int amount) {
		//check for Insufficient balance and minimum balance.
		if(amount > userData.getUserBalanceAmount() ) {
			System.out.println("Insufficient balance.");
		} else if ((userData.getUserBalanceAmount() - 
				(amount + calculateFee(amount,configData.getWithdraw())) < 2000)) {
			System.out.println("You should have minimum balance of 2000");
		} else {
			userData.setUserBalanceAmount(userData.getUserBalanceAmount()-(amount + ((amount * 0.14) / 100 )));
			showBalance();
			Date date = new Date();
			userData.addBankStatement(new BankStatement(userData.getUserName(), "withdraw", amount, userData.getUserBalanceAmount() , date, "SBI"));
		}	
	}
	
	//To deposit an amount
	@Override
	public void deposit(int amount) {
		userData.setUserBalanceAmount(userData.getUserBalanceAmount() + (amount - calculateFee(amount, configData.getDeposit()))) ;
	    showBalance();
	    Date date = new Date();
		userData.addBankStatement(new BankStatement(userData.getUserName(), "deposit", amount, userData.getUserBalanceAmount() , date, "SBI"));
	}


	@Override
	public void displayBankStatement() {
		for(BankStatement bankStatement : userData.getBankStatement()) {
			System.out.println("---------------------------------------------------");
			System.out.println("Bank Name: " + bankStatement.getBankName());
			System.out.println("User Name: " + bankStatement.getUsername());
			if(bankStatement.getType().equals("deposit")) {
				System.out.println("Deposited amount: " + bankStatement.getAmount());
			} else if(bankStatement.getType().equals("withdraw")) {
				System.out.println("Withdrawn amount: " + bankStatement.getAmount());
			}
			System.out.println("User Balance: " + bankStatement.getUserBalance());
			System.out.println("Transaction Date:" + bankStatement.getTransactionDate());
			System.out.println("---------------------------------------------------");
		}
		
	}

	@Override
	
 public void helpandsupport(){
		
		Date date = new Date();
		HelpandSupport helpandSupport=new HelpandSupport("unable to Login", userData.getUserName(),date,"not solved","Sudhan",date);
		userData.addHelpAndSupport(helpandSupport);
		
		System.out.println("Enter for the Following Services");
		System.out.println("Enter 1 for contacting supporting");
		System.out.println("Enter 2 for posting the Query");
		System.out.println("Enter 3 for chatting with bot");
		System.out.println("Enter 4 to exit");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			contactSupport();
			break;
		case 2:
			postquery();
			break;
		case 3:
			chatBot();
			break;
		case 4:
			System.out.println("exiting");
			break;
		default:
			System.out.println("enter valid choice");
	}
	}
	
	public void contactSupport() {
		System.out.println("enter number +918029... to contact agent");
	}
	
	public void postquery() {
		System.out.println("enter the Struggle you faced");
		String query = sc.nextLine();
	}
	
	public void chatBot() {
		System.out.println("Hi I am Helpbot How can I get you ?");
	}
	//To calculate the fees
	private double calculateFee(int amount, double rate) {
		return (amount * rate) / 100;
	}
}


