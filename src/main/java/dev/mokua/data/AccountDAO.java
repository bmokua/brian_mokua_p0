package dev.mokua.data;

import dev.mokua.entities.Account;
import dev.mokua.utilities.List;

public interface AccountDAO {

    //Create account
    Account createAccount(Account account);
    //Read account (account info including balance)
    Account getAccountByAccountNumber(int accountNumber);

    List<Account> getAllAccounts();

    //Update account (including deposits and withdrawals)
    Account updateAccount(Account account);

    //Delete
    boolean deleteAccountByAccountId(int accountId);

    Account logIn(String userName, String Password);




}
