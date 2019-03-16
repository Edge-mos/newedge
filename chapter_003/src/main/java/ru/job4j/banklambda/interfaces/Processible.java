package ru.job4j.banklambda.interfaces;
import ru.job4j.banklambda.models.Account;
import ru.job4j.banklambda.models.User;
import java.util.List;


public interface Processible {
    void addUser(User user);
    void deleteUser(User user);
    void addAccountToUser(String passport, Account account);
    void deleteAccountFromUser(String passport, Account account);
    List<Account> getUserAccounts(String passport);
    boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount);
}
