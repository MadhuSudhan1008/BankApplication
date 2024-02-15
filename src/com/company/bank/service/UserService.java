package com.company.bank.service;

import java.util.LinkedList;


import com.company.bank.data.user.User;

public class UserService {
	static LinkedList<User> UserList = new LinkedList<>();
	
	static {
		UserList.add(new User("Sudhan", 10000, "admin", "theni", "theni", "admin"));
		UserList.add(new User("kishan", 20000, "1234", "theni", "theni", "user"));
		UserList.add(new User("gugan", 30000, "1234", "theni", "theni", "user"));	
	}

	public User CheckIfUserExists(String username,String password,String type) {
		for (User u:UserList) {
			System.out.println(u.getUserName()+ u.getUserpassword()+u.getRole());
			if(username.equals(u.getUserName()) && password.equals(u.getUserpassword()) && type.equals(u.getRole())) {
				return u;
		}
	}
	return null;
	}


	public boolean AddUser(String name,String password) {
	User ExistingUser = CheckIfUserExists(name);
	if (ExistingUser==null) {
		UserList.add(new User(name,password));
		return true;
	}
	return false;
}
	public Boolean RemoveUser(String Username) {
	User ExistingUser = CheckIfUserExists(Username);
	if (ExistingUser!=null) {
		UserList.remove(ExistingUser);
		return true;
	}
	return false;
	}
	
	public Boolean checkRole(String rolename){
		for(User u:UserList) {
			if(rolename.equals(u.getRole())) {
				return true;
			}
			
		}
		return false;
	}
	public User CheckIfUserExists(String username) {
		for (User u:UserList){
			if (username.equals(u.getUserName())){
				return u;
			}
		}
		return null;
	}


}
	


