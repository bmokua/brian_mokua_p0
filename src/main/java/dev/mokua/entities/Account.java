package dev.mokua.entities;

public class Account {

    private int accountId;
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private double balance;


    public Account(){

    }

    public Account(int accountId, String firstName, String lastName,
                   double balance, String userName, String passWord) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountNumber) {
        this.accountId = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", balance=" + balance +
                '}';
    }
}
