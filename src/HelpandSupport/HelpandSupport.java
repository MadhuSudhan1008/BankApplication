package HelpandSupport;

import java.util.Date;

public class HelpandSupport {
	String complaint;
	String UserName;
	Date date;
	String status;
	String AdminUserName;
	Date dateresolved;
	
	
	public HelpandSupport(String complaint, String userName, Date date, String status, String adminUserName,
			Date dateresolved) {
		super();
		this.complaint = complaint;
		UserName = userName;
		this.date = date;
		this.status = status;
		AdminUserName = adminUserName;
		this.dateresolved = dateresolved;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAdminUserName() {
		return AdminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		AdminUserName = adminUserName;
	}
	public Date getDateresolved() {
		return dateresolved;
	}
	public void setDateresolved(Date dateresolved) {
		this.dateresolved = dateresolved;
	}
	
	
}
