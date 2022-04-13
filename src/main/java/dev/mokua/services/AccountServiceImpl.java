package dev.mokua.services;

import dev.mokua.data.AccountDAO;
import dev.mokua.entities.Account;
import dev.mokua.utilities.List;

public class AccountServiceImpl implements AccountService{

    public AccountDAO accountDAO;

    //Dependency injection. Building an object that uses another object within it
    public AccountServiceImpl(AccountDAO accountDAO) { this.accountDAO = accountDAO; }

    @Override
    public Account createAccount(Account account) {
        return this.accountDAO.createAccount(account);
    }

    @Override
    public Account getAccountByAccountNumber(int accountNumber) {
        return this.accountDAO.getAccountByAccountNumber(accountNumber);
    }

    @Override
    public List<Account> getAllAccounts() {
        return this.accountDAO.getAllAccounts();
    }

    @Override
    public Account updateAccount(Account account) {
        return this.accountDAO.updateAccount(account);
    }

    @Override
    public boolean deleteAccountByAccountId(int accountId) {
        return this.accountDAO.deleteAccountByAccountId(accountId);
    }

    @Override
    public Account logIn(String userName, String passWord) {
        return this.accountDAO.logIn(userName, passWord);
    }
}
