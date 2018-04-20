package ru.job4j.bank;
import org.junit.Test;
import ru.job4j.bank.models.Bank;
import ru.job4j.bank.models.Account;
import ru.job4j.bank.models.User;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 16.04.2018.
 */
public class BankTest {
    @Test
    public void whenUserNotYetClientThanAddInListAndReturnTrue() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "545384"));
        assertThat(bank.getAllListClients().containsKey(new User("Ivan", "545384")), is(true));
    }

    @Test
    public void whenAddUsersWithSamePassportThanDuplicatesNotAllowedAndReturnFalse() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "545384"));
        bank.addUser(new User("Petr", "545384"));
        assertThat(bank.getAllListClients().size(), is(1));
    }

    @Test
    public void whenDifferentUserAddedThanSizeOfListIsGreatherThan1() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "545384"));
        bank.addUser(new User("Vladimir", "485123"));
        assertThat(bank.getAllListClients().size(), greaterThan(1));
    }

    @Test
    public void whenDeleteUserFromList() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "545384"));
        bank.deleteUser(new User("Ivan", "545384"));
        assertThat(bank.getAllListClients().size(), is(0));
        System.out.println(bank.getAllListClients());
    }

    @Test
    public void whenDeleteNotPresentedUserInListThanSizeOfListIsSame() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "545384"));
        bank.deleteUser(new User("Petr", "555384"));
        assertThat(bank.getAllListClients().size(), is(1));
    }

    @Test
    public void whenAddNewAccountToUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "545384"));
        Account addedAccount = new Account(10000, "RUR01_12345");
        bank.addAccountToUser("545384", addedAccount);
        String result = bank.getAllListClients().get(new User("545384")).get(0).getRequisites();
        assertThat(result, is(addedAccount.getRequisites()));
    }

    @Test
    public void whenAddMoreThanOneAccountToUserThanSizeOfListOfAccountsGreatherThan1() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "545384"));
        Account firstAccount = new Account(10000, "RUR01_12345");
        bank.addAccountToUser("545384", firstAccount);
        Account secondAccount = new Account(12345, "RUR02_32112");
        bank.addAccountToUser("545384", secondAccount);
        int numberOfUserAccounts = bank.getAllListClients().get(new User("545384")).size();
        assertThat(numberOfUserAccounts, greaterThan(1));
    }

    @Test
    public void whenDeleteAccountFromToUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "545384"));
        Account firstAccount = new Account(10000, "RUR01_12345");
        bank.addAccountToUser("545384", firstAccount);
        Account secondAccount = new Account(12345, "RUR02_32112");
        bank.addAccountToUser("545384", secondAccount);
        bank.deleteAccountFromUser("545384", secondAccount);
        int numberOfUserAccounts = bank.getAllListClients().get(new User("545384")).size();
        assertThat(numberOfUserAccounts, is(1));
    }

    @Test
    public void whenUserHasAccountsThanReturnsListOfAccounts() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "545384"));
        Account firstAccount = new Account(10000, "RUR01_12345");
        bank.addAccountToUser("545384", firstAccount);
        Account secondAccount = new Account(12345, "RUR02_32112");
        bank.addAccountToUser("545384", secondAccount);
        List<Account> result = new ArrayList<>();
        result.add(firstAccount);
        result.add(secondAccount);
        assertThat(result, is(bank.getAllListClients().get(new User("545384"))));
    }

    @Test
    public void whenUserTransfersFoundsToAnotherUserThanTrue() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "545384"));
        Account srcAccount = new Account(10000, "RUR01_12345");
        bank.addAccountToUser("545384", srcAccount);
        bank.addUser(new User("Petr", "765384"));
        Account dstAccount = new Account(0, "RUR01_11111");
        bank.addAccountToUser("765384", dstAccount);
        boolean result = bank.transferMoney("545384", "RUR01_12345", "765384", "RUR01_11111", 5000);
        System.out.println("After: " + bank.getAllListClients());
        assertThat(result, is(true));
    }

    @Test
    public void whenInsufficientFoundsThanFalse() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "545384"));
        Account srcAccount = new Account(10000, "RUR01_12345");
        bank.addAccountToUser("545384", srcAccount);
        bank.addUser(new User("Petr", "765384"));
        Account dstAccount = new Account(0, "RUR01_11111");
        bank.addAccountToUser("765384", dstAccount);
        boolean result = bank.transferMoney("545384", "RUR01_12345", "765384", "RUR01_11111", 12000);
        assertThat(result, is(false));
    }

    @Test
    public void whenUserTransfersFoundsToHimselfToAnotherAccountThanTrue() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "545384"));
        Account firstAccount = new Account(10000, "RUR01_12345");
        Account secondAccount = new Account(0.0, "RUR02_55555");
        bank.addAccountToUser("545384", firstAccount);
        bank.addAccountToUser("545384", secondAccount);
        boolean result = bank.transferMoney("545384", "RUR01_12345", "545384", "RUR02_55555", 10000);
        assertThat(result, is(true));
    }
}
