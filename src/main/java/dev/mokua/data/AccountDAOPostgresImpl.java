package dev.mokua.data;

import dev.mokua.entities.Account;
import dev.mokua.utilities.ArrayList;
import dev.mokua.utilities.ConnectionUtil;
import dev.mokua.utilities.List;


import java.sql.*;

public class AccountDAOPostgresImpl implements AccountDAO{


    @Override
    public Account createAccount(Account account) {
        // Values used to create an account(accountNumber, firstAndLastName, checkingBalance, savingsBalance, userLogin)

        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "insert into account(first_name, last_name, checking_balance, " +
                    "user_name, pass_word) values (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //ps.setInt(1, account.getAccountId());
            ps.setString(1, account.getFirstName());
            ps.setString(2, account.getLastName());
            ps.setDouble(3, account.getBalance());
            ps.setString(4,account.getUserName());
            ps.setString(5, account.getPassWord());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys(); //ResultSet a virtual table of results
            rs.next(); //move to the first record of the result set
            int generatedAccountNumber = rs.getInt("account_id");
            account.setAccountId(generatedAccountNumber);
            return account;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Account getAccountByAccountNumber(int accountNumber){
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from account where account_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,accountNumber);

            ResultSet rs = ps.executeQuery();
            rs.next(); // move to first record
            Account account = new Account();
            account.setAccountId(rs.getInt("account_id"));
            account.setFirstName(rs.getString("first_name"));
            account.setLastName(rs.getString("last_name"));
            account.setBalance(rs.getDouble("checking_balance"));

            return account;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Account> getAllAccounts() {

        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from account";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Account> accounts = new ArrayList();
            while (rs.next()){
                Account account = new Account();
                account.setAccountId(rs.getInt("account_number"));
                account.setFirstName(rs.getString("first_name"));
                account.setLastName(rs.getString("last_name"));
                account.setBalance(rs.getDouble("checking_balance"));


            }

            return accounts;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Account updateAccount(Account account) {

        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "update account set first_name = ?, last_name = ?, checking_balance = ?, where account_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account.getFirstName());
            ps.setString(2, account.getLastName());
            ps.setDouble(3, account.getBalance());
            ps.setInt(4, account.getAccountId());
            ps.executeUpdate();
            return  account;

        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }

    }

    @Override
    public boolean deleteAccountByAccountId(int accountId) {
        try{
            Connection conn = ConnectionUtil.createConnection();
            String sql = "delete from account where account_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accountId);
            ps.execute();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Account logIn(String userName, String passWord) {

        Account account = new Account();
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from account where user_name = ? and pass_word = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, passWord);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                account.setFirstName(rs.getString("first_name"));
                account.setLastName(rs.getString("last_name"));
                account.setUserName(rs.getString("user_name"));
                account.setUserName(rs.getString("pass_word"));
                account.setBalance(rs.getDouble("checking_balance"));

            }

            return account;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
