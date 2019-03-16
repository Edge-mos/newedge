package ru.job4j.banklambda;

import org.junit.Test;
import ru.job4j.banklambda.exeptions.NoSuchAccountException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankUserTest {

    @Test
    public void whenAddNewAccountThanTrue() {
        BankUser client = new BankUser("Ivan", "12345");
        assertThat(client.addAccount("101rur", 5000), is(true));
    }

    @Test
    public void whenAccountAlreadyExistsThanFalse() {
        BankUser client = new BankUser("Ivan", "12345");
        client.addAccount("101rur", 5000);
        assertThat(client.addAccount("101rur", 5000), is(false));
    }

    @Test
    public void whenDeleteExistingAccountThanTrue() {
        BankUser client = new BankUser("Ivan", "12345");
        client.addAccount("101rur", 5000);
        assertThat(client.deleteAccount("101rur"), is(true));
    }

    @Test(expected = NoSuchAccountException.class)
    public void whenDeleteAbsentAccountThahNoSuchExeption() {
        BankUser client = new BankUser("Ivan", "12345");
        client.deleteAccount("101rur");
    }

    @Test
    public void whenGetUserAccounts() {
        BankUser client = new BankUser("Ivan", "12345");
        client.addAccount("101rur", 5000);
        client.addAccount("102usd", 3000);
        List<String> collect = new ArrayList<>(client.getUserAccounts().keySet());
        assertThat(collect.get(0), is("101rur"));
        assertThat(collect.get(1), is("102usd"));
    }

    @Test
    public void whenGetExistingAccount() {
        BankUser client = new BankUser("Ivan", "12345");
        client.addAccount("101rur", 5000);
        client.addAccount("102usd", 3000);
        BankUser.Account account = client.getAccount("101rur");
        assertThat(account.getRequisites(), is("101rur"));
        assertThat(account.getAmount(), is(5000d));
    }

    @Test(expected = NoSuchAccountException.class)
    public void whenGetAbsentAccountThanNoSuchExeption() {
        BankUser client = new BankUser("Ivan", "12345");
        client.addAccount("101rur", 5000);
        client.getAccount("102usd");
    }
}