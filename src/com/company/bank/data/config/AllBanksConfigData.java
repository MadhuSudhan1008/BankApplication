package com.company.bank.data.config;

public class AllBanksConfigData {
	double withdraw;
	double deposit;
	public AllBanksConfigData(double withdrawtaxpercent,double deposittaxpercent) {
		withdraw=withdrawtaxpercent;
		deposit=deposittaxpercent;
		
	}
	
	public double getDeposit() {
		return deposit;
	}
	
	public double getWithdraw() {
		return withdraw;
	}
}
