package ru.job4j.bank.interfaces.implemented;

import ru.job4j.bank.interfaces.Processible;
import ru.job4j.bank.models.Account;
import ru.job4j.bank.models.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 16.04.2018.
 */

public abstract class AbstractBank implements Processible {
    public abstract Map<User, List<Account>> getAllListClients();

    protected boolean canTransfer(Account src, Account dst, double amount) {
        boolean result = false;
        if (src.getValue() >= amount) {
            src.setValue(src.getValue() - amount);
            dst.setValue(dst.getValue() + amount);
            result = true;
        }
        return result;
    }
}
