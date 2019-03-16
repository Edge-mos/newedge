package ru.job4j.banklambda;

import org.junit.Test;
import ru.job4j.banklambda.exeptions.InsufficientFoundsException;
import ru.job4j.banklambda.exeptions.NoSuchAccountException;
import ru.job4j.banklambda.exeptions.NoSuchClientException;
import ru.job4j.banklambda.interfaces.BankClient;
import ru.job4j.banklambda.interfaces.BankProcess;

import java.util.List;
import java.util.function.BiPredicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {

    @Test
    public void whenAddNewClientThanTrue(){
        BankProcess bank = new Bank();
        assertThat(bank.addUser(new BankUser("Ivan", "12345")), is(true));
    }

    @Test
    public void whenAddExistingClientThanFalse(){
        BankProcess bank = new Bank();
        bank.addUser(new BankUser("Ivan", "12345"));
        assertThat(bank.addUser(new BankUser("Ivan", "12345")), is(false));
    }

    @Test
    public void whenDeleteExistingClientThanTrue() {
        BankProcess bank = new Bank();
        bank.addUser(new BankUser("Ivan", "12345"));
        assertThat(bank.deleteUser(new BankUser("Ivan", "12345")), is(true));
    }

    @Test
    public void whenDeleteAbsentClientThanFalse() {
        BankProcess bank = new Bank();
        assertThat(bank.deleteUser(new BankUser("Ivan", "12345")), is(false));
    }

    @Test
    public void whenSearchExistingClient() {
        BankProcess bank = new Bank();
        BankClient client = new BankUser("Ivan", "12345");
        bank.addUser(client);
        assertThat(bank.searchClient("12345"), is(client));
    }

    @Test(expected = NoSuchClientException.class)
    public void whenSearchAbsentClientThenNoSuchClientException() {
        BankProcess bank = new Bank();
        bank.searchClient("12345");
    }

    @Test
    public void whenAddNewAccountToClientThanTrue() {
        BankProcess bank = new Bank();
        bank.addUser(new BankUser("Ivan", "12345"));
        assertThat(bank.addAccountToUser("12345", "101rur", 10_000), is(true));
        List<BankUser.Account> userAccounts = bank.getUserAccounts("12345");
        assertThat(userAccounts.get(0).getRequisites(), is("101rur"));
    }

    @Test
    public void whenDeleteExistingAccountThanTrue() {
        BankProcess bank = new Bank();
        bank.addUser(new BankUser("Ivan", "12345"));
        bank.addAccountToUser("12345", "101rur", 10_000);
        assertThat(bank.deleteAccountFromUser("12345", "101rur"), is(true));
    }

    @Test(expected = NoSuchAccountException.class)
    public void whenDeleteAbsentAccountThanFalse() {
        BankProcess bank = new Bank();
        bank.addUser(new BankUser("Ivan", "12345"));
        bank.deleteAccountFromUser("12345", "101rur");
    }

    @Test
    public void whenTransferIsSufficientThanTrue() {
        BankProcess bank = new Bank();
        bank.addUser(new BankUser("Ivan", "12345"));
        bank.addAccountToUser("12345", "101rur", 5000);
        bank.addUser(new BankUser("Marina", "6789"));
        bank.addAccountToUser("6789", "102rur", 2000);
        assertThat(bank.transferMoney("12345", "101rur", "6789", "102rur", 1000), is(true));
        List<BankUser.Account> ivanAcc = bank.getUserAccounts("12345");
        assertThat(ivanAcc.get(0).getAmount(), is(4000d));
    }

    @Test(expected = InsufficientFoundsException.class)
    public void whenTransferIsInsufficientThanFalse() {
        BankProcess bank = new Bank();
        bank.addUser(new BankUser("Ivan", "12345"));
        bank.addAccountToUser("12345", "101rur", 5000);
        bank.addUser(new BankUser("Marina", "6789"));
        bank.addAccountToUser("6789", "102rur", 2000);
        bank.transferMoney("12345", "101rur", "6789", "102rur", 10000);
    }
}