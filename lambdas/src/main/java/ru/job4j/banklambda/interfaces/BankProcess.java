package ru.job4j.banklambda.interfaces;

import ru.job4j.banklambda.BankUser;
import ru.job4j.banklambda.exeptions.InsufficientFoundsException;
import ru.job4j.banklambda.exeptions.NoSuchAccountException;
import ru.job4j.banklambda.exeptions.NoSuchClientException;

import java.util.List;
import java.util.function.BiPredicate;

public interface BankProcess {
    boolean addUser(BankClient client);
    boolean deleteUser(BankClient client);
    boolean addAccountToUser(String passport, String accReq, double accAmount) throws NoSuchClientException;
    boolean deleteAccountFromUser(String passport, String accReq) throws NoSuchClientException;
    List<BankUser.Account> getUserAccounts(String passport) throws NoSuchClientException;
    boolean transferMoney(String srcPassport, String srcRequisite,
                          String dstPassport, String dstRequisite, double amount) throws NoSuchAccountException, InsufficientFoundsException;
    BankClient searchClient(String passport) throws NoSuchClientException;
}
