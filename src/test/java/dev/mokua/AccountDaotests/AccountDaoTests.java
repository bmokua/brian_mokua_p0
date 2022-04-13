package dev.mokua.AccountDaotests;

import dev.mokua.data.AccountDAO;
import dev.mokua.data.AccountDAOPostgresImpl;
import dev.mokua.entities.Account;
import dev.mokua.utilities.List;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountDaoTests {

    static AccountDAO accountDAO = new AccountDAOPostgresImpl();
    static Account testAccount = null;

    @Test
    @Order(1) //This helps with the order of test execution
    void create_account_test(){

        //An entity that is created but not yet saved should have an account of 0
        // Once saved that account should be some non-zero value
        Account account1 = new Account(0,"Brian", "Mokua",0,
                "user1", "pass1");
        Account savedAccount = accountDAO.createAccount(account1);
        AccountDaoTests.testAccount = account1;
        Assertions.assertNotEquals(0, savedAccount.getAccountId());
    }
    @Test
    @Order(2)
    void get_account_by_AccountNumber(){
        Account retrievedAccount = accountDAO.getAccountByAccountNumber(testAccount.getAccountId());
        System.out.println(retrievedAccount);
        Assertions.assertEquals(0, retrievedAccount.getAccountId());
    }
    @Test
    @Order(2)
    void get_all_accounts(){
        //Create accounts
        Account account1 = new Account(0, "Josh", "Smith", 0,  "user2", "pass2");
        Account account2 = new Account(0, "Steve", "Williams", 0, "user3", "pass3");
        accountDAO.createAccount(account1);
        accountDAO.createAccount(account2);
        List<Account> accounts = accountDAO.getAllAccounts();
        int totalAccounts = accounts.size();
        Assertions.assertTrue(totalAccounts >= 2);
    }
}
