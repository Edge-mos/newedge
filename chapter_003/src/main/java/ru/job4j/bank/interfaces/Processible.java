package ru.job4j.bank.interfaces;
import ru.job4j.bank.models.Account;
import ru.job4j.bank.models.User;
import java.util.List;
import java.util.Map;


public interface Processible {
    void addUser(User user);
    void deleteUser(User user);
    void addAccountToUser(String passport, Account account);
    void deleteAccountFromUser(String passport, Account account);
    List<Account> getUserAccounts(String passport);
    boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount);
}
