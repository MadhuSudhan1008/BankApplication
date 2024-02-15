package BankStatement;

import java.util.Date;

public class BankStatement {
	
	    String username;
	    String type;
	    double amount;
	    double userBalance;
	    Date transactionDate;
	    String bankName;
		public BankStatement(String username, String type, double amount, double userBalance, Date transactionDate,
				String bankName) {
			super();
			this.username = username;
			this.type = type;
			this.amount = amount;
			this.userBalance = userBalance;
			this.transactionDate = transactionDate;
			this.bankName = bankName;
		}
		public String getUsername() {
			return username;
		}
		public String getType() {
			return type;
		}
		public double getAmount() {
			return amount;
		}
		public double getUserBalance() {
			return userBalance;
		}
		public Date getTransactionDate() {
			return transactionDate;
		}
		public String getBankName() {
			return bankName;
		}    
}

