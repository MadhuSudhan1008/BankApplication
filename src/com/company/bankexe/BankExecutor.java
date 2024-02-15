package com.company.bankexe;

import java.util.Scanner;

import com.company.bank.data.user.User;
import com.company.bank.service.SbiBankService;
import com.company.bank.service.UserService;

public class BankExecutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();

        do {
            System.out.println("Enter 1 for Admin 2 for User");
            int role = sc.nextInt();

            switch (role) {
                case 1:
                    System.out.println("Enter The Admin Name");
                    String adminName = sc.next(); // Use next() instead of nextLine() to avoid skipping inputs
                    System.out.println("Enter The Password");
                    String adminPassword = sc.next();

                    User adminUser = userService.CheckIfUserExists(adminName, adminPassword, "admin");
                    if (adminUser != null) {
                        do {
                            System.out.println("Enter 1 for Add User 2 for Remove User");
                            int adminChoice = sc.nextInt();
                            switch (adminChoice) {
                                case 1:
                                    System.out.println("Enter the New User Name :");
                                    String newUserName = sc.next();
                                    System.out.println("Enter The New User Password ");
                                    String newUserPassword = sc.next();

                                    if (userService.AddUser(newUserName, newUserPassword)) {
                                        System.out.println("New User Added Successfully");
                                    } else {
                                        System.err.println("User already Exists!");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Enter The User name to remove");
                                    String userToRemove = sc.next();

                                    if (userService.RemoveUser(userToRemove)) {
                                        System.out.println("User Removed Successfully");
                                    } else {
                                        System.err.println("User Not Exists");
                                    }
                                    break;
                                default:
                                    System.out.println(".......Invalid Choice!!!!!!!");
                                    break;
                            }
                            System.out.println("Enter Y to continue or N to Exit");
                        } while (sc.next().charAt(0) == 'Y'); // Use next() here too
                    } else {
                        System.out.println("Invalid Credentials");
                    }
                    break;

                case 2:
                    System.out.println("Enter The User Name :");
                    String userName = sc.next();
                    System.out.println("Enter The Password");
                    String password = sc.next();
                    

                    User userExisting = userService.CheckIfUserExists(userName);
                    if (userExisting != null) {
                        System.out.println("You are Logged in Successfully!");

                        SbiBankService service = new SbiBankService(userExisting);
                        if (service != null) {
                            int choice;
                            do {
                                System.out.println("1--->See Balance\n2--->Withdraw\n3--->Deposit\n4--->Help and Support\n5--->Display Bank Statement");
                                choice = sc.nextInt();
                                switch (choice) {
                                    case 1:
                                        service.showBalance();
                                        break;
                                    case 2:
                                        System.out.println("Enter amount to withdraw:");
                                        int amount = sc.nextInt();
                                        service.withdraw(amount);
                                        break;
                                    case 3:
                                        System.out.println("Enter amount to deposit:");
                                        int amt = sc.nextInt();
                                        service.deposit(amt);
                                        break;
                                    case 4:
                                        service.helpandsupport();
                                        break;
                                    case 5:
                                        service.displayBankStatement();
                                        break;
                                    default:
                                        System.out.println("Invalid Choice");
                                        break;
                                }
                            } while (choice != 4);
                        }
                    } else {
                        System.out.println("Invalid Credentials");
                    }
                    break;
                default:
                    System.out.println("Invalid Role!");
                    break;
            }
            System.out.println("Do you want to continue? (Y/N)");
        } while (sc.next().equalsIgnoreCase("Y"));
        sc.close(); // Close the Scanner object when done.
    }
}
