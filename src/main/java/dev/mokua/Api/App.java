package dev.mokua.Api;

import dev.mokua.data.AccountDAOPostgresImpl;
import dev.mokua.services.AccountServiceImpl;
import dev.mokua.services.AccountService;
import dev.mokua.entities.Account;


import java.util.Scanner;

public class App {

    public static AccountService accountService = new AccountServiceImpl(new AccountDAOPostgresImpl());


    public static void main(String[ ]args){


                Boolean run = true;

                Account currentAccount = new Account();
                Scanner sc = new Scanner(System.in);
                int mainChoice = 0;

                while (mainChoice <= 3 && run.equals(true)) {

                    System.out.println("Welcome To Awesome Bank");
                    System.out.println("Please select a number to proceed: ");
                    System.out.println("1. Create New User");
                    System.out.println("2. Existing User");
                    System.out.println("3. Exit");
                    mainChoice = sc.nextInt();


                        switch (mainChoice) {

                            case 1:

                                System.out.println("Please enter first name : ");
                                currentAccount.setFirstName(sc.next());
                                System.out.println("Please enter last name : ");
                                currentAccount.setLastName(sc.next());
                                System.out.println("Please enter username you wish to use for this account : ");
                                currentAccount.setUserName(sc.next());
                                System.out.println("Please enter password you wish to use for this account : ");
                                currentAccount.setPassWord(sc.next());
                                System.out.println("Enter your deposit amount: ");
                                currentAccount.setBalance(sc.nextDouble());

                                currentAccount = accountService.createAccount(currentAccount);
                                break;

                            case 2:
                                Account account = accountLogin();

                                System.out.println("Select an option: ");
                                System.out.println("1. Account Balance: ");
                                System.out.println("2. Deposit: ");
                                System.out.println("3. Withdraw: ");
                                System.out.println("4. Exit");
                                int subChoice = 0;
                                double deposit;
                                double withdraw;

                                subChoice = sc.nextInt();
                                double balance = 0;
                                if (subChoice == 1) {
                                    System.out.println("Account Balance " + "$" + account.getBalance());
                                    //run = false;
                                } else if (subChoice == 2) {
                                    balance = account.getBalance();

                                    System.out.println("Enter the amount you want to deposit:");
                                    deposit = sc.nextDouble();
                                    if (deposit > 0.0) {
                                        balance += deposit;
                                        App.accountService.updateAccount(account);
                                        //account.setBalance(balance);
                                    } else {
                                        System.out.println("Enter a valid amount please!");

                                    }
                                    //run = false;
                                } else if (subChoice == 3) {

                                    System.out.println("Enter the amount you want to withdraw:");
                                    withdraw = sc.nextDouble();
                                    if (withdraw <= 0 || balance <= 0 ||((balance-withdraw)< 0)) {
                                            System.out.println("Insufficient funds");
                                    }else{
                                        balance -= withdraw;
                                        App.accountService.updateAccount(account);
                                        //account.setBalance(balance);
                                    }


                                } else if (subChoice == 4) {

                                    run = false;
                                    System.out.println("Exit Program");
                                }

                                break;

                            case 3: {
                                run = false;
                                System.out.println("Exit Program");
                            }
                            break;
                            default:
                                    System.out.println("Invalid choice");
                        }
                    }
    }


    public static Account accountLogin(){
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String userName = sc2.next();

        System.out.println("Enter the password: ");
        String password = sc2.next();

        Account account = accountService.logIn(userName, password);


        return account;
    }

}
