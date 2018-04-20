package ru.job4j.bank.models;

import ru.job4j.bank.interfaces.implemented.AbstractBank;

import java.util.*;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 16.04.2018.
 */
public class Bank extends AbstractBank {
    /**
     * Список клиентов банка, к каждому клиенту привязан счёт или несколько счетов.
     */
    private Map<User, List<Account>> bankClients = new HashMap<>();
    /**
     * Добавляет клиента, если таковой отсутствует. Проверка идёт по номеру паспорта.
     * @param user Методы equals() и hashCode вычисляются по полю passport.
     */
    @Override
    public void addUser(User user) {
        this.bankClients.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет клиента из списка, если такой клиент есть в списке.
     * @param user Клиент по номеру паспорта.
     */
    @Override
    public void deleteUser(User user) {
       if (this.bankClients.containsKey(user)) {
           this.bankClients.remove(user);
       }
    }

    /**
     * Добавляет аккаунт клиенту, если он есть в списке.
     * @param passport Номер паспорта.
     * @param account Реквизиты аккаунта.
     */
    @Override
    public void addAccountToUser(String passport, Account account) {
        this.bankClients.get(new User(passport)).add(account);
    }

    /**
     * Удаляет аккаунт клиента, если он есть в списке(по номеру паспорта), для удаления используются реквизиты аккаунта(уникальны)
     * @param passport Номер паспорта.
     * @param account Реквизиты аккаунта.
     */
    @Override
    public void deleteAccountFromUser(String passport, Account account) {
        this.bankClients.get(new User(passport)).remove(account);
    }

    /**
     * Возвращает список Аккаунтов пользователя.
     * @param passport Номер паспорта.
     * @return Список всех аккаунтов.
     */
    @Override
    public List<Account> getUserAccounts(String passport) {
        return this.bankClients.get(new User(passport));
    }

    /**
     * Делает перевод со счёта одного клиента на счёт другого, если позволяет метод canTransfer() (находится в абстрактном классе).
     * @param srcPassport Номер паспорта отправителя платежа.
     * @param srcRequisite Реквизиты счёта отправителя платежа.
     * @param dstPassport Номер паспорта получателя платежа.
     * @param dstRequisite Реквизиты счёта получателя платежа.
     * @param amount Сумма перевода.
     * @return Возвращает true, если перевод осуществим и вычитает сумму перевода со счёта отправителя и добавляет на счёт получателя.
     */
    @Override
    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        User srcUser = new User(srcPassport);
        User dstUser = new User(dstPassport);
        Account srcAccount = new Account(srcRequisite);
        Account dstAccount = new Account(dstRequisite);
        return this.bankClients.get(srcUser).contains(srcAccount) && this.bankClients.get(dstUser).contains(dstAccount)
                && canTransfer(getCurrentAccount(srcPassport, srcAccount), getCurrentAccount(dstPassport, dstAccount), amount);
    }

    /**
     *
     * @return Выводит все ключи-значения в банке.
     */
    @Override
    public Map<User, List<Account>> getAllListClients() {
        return this.bankClients;
    }

    /**
     *
     * @param passport Реквизиты паспорта.
     * @param account Значение, удовлетворяющее в критерии поиска среди счетов.
     * @return Возвращает конкретный счёт пользователя из возможного списка счетов.
     */
    private Account getCurrentAccount(String passport, Account account) {
        List<Account> allUserAccounts = getUserAccounts(passport);
        return allUserAccounts.get(allUserAccounts.indexOf(account));

    }
}
