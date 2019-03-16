package ru.job4j.banklambda.interfaces;

import ru.job4j.banklambda.BankUser;
import ru.job4j.banklambda.exeptions.NoSuchAccountException;

import java.util.List;
import java.util.Map;

public interface BankClient {
    String getPassport();
    boolean addAccount(String req, double amount);
    boolean deleteAccount(String req) throws NoSuchAccountException;
    Map<String, BankUser.Account> getUserAccounts();
    BankUser.Account getAccount(String requisites) throws NoSuchAccountException;
}
