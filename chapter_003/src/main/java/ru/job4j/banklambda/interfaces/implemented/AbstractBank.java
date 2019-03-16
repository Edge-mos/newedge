package ru.job4j.banklambda.interfaces.implemented;

import ru.job4j.banklambda.interfaces.Processible;
import ru.job4j.banklambda.models.Account;
import ru.job4j.banklambda.models.User;

import java.util.List;
import java.util.Map;

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
