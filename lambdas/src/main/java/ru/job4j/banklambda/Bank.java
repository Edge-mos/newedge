package ru.job4j.banklambda;

import ru.job4j.banklambda.exeptions.InsufficientFoundsException;
import ru.job4j.banklambda.exeptions.NoSuchAccountException;
import ru.job4j.banklambda.exeptions.NoSuchClientException;
import ru.job4j.banklambda.interfaces.BankClient;
import ru.job4j.banklambda.interfaces.BankProcess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;

public class Bank implements BankProcess {
    private final Set<BankClient> bankClients = new HashSet<>();

    @Override
    public boolean addUser(final BankClient client) {
        return !this.isBankClient(client) && this.bankClients.add(client);
    }

    @Override
    public boolean deleteUser(final BankClient client) {
        return this.isBankClient(client) && this.bankClients.remove(client);
    }

    @Override
    public boolean addAccountToUser(final String passport, final String accReq, final double accAmount) throws NoSuchClientException {
        return this.searchClient(passport).addAccount(accReq, accAmount);
    }

    @Override
    public boolean deleteAccountFromUser(final String passport, final String accReq) throws NoSuchClientException {
        return this.searchClient(passport).deleteAccount(accReq);
    }

    @Override
    public List<BankUser.Account> getUserAccounts(final String passport) throws NoSuchClientException {
        return new ArrayList<>(this.searchClient(passport)
                .getUserAccounts()
                .values());
    }

    @Override
    public boolean transferMoney(final String srcPassport, final String srcRequisite, final String dstPassport,
                                 final String dstRequisite, final double amount) throws NoSuchAccountException, InsufficientFoundsException {
        BankUser.Account srcAcc = this.getUserAcc(srcPassport, srcRequisite);
        BankUser.Account dstAcc = this.getUserAcc(dstPassport, dstRequisite);
        if (this.canTransfer(srcAcc, amount)) {
            srcAcc.setAmount(srcAcc.getAmount() - amount);
            dstAcc.setAmount(dstAcc.getAmount() + amount);
            return true;
        }
        throw new InsufficientFoundsException(String.format("SrcAcc founds: %f < %f", srcAcc.getAmount(), amount));
    }

    private boolean isBankClient(final BankClient client) {
        return this.bankClients.contains(client);
    }

    // TODO: 3/13/19 Оттестировать с предикатом в параметрах
    @Override
    public BankClient searchClient(final String passport) throws NoSuchClientException {
        return this.bankClients
                .stream()
                .filter(client -> client.getPassport().equals(passport))
                .findFirst()
                .orElseThrow(NoSuchClientException::new);
    }

    private BankUser.Account getUserAcc(final String passport, final String req) throws NoSuchClientException {
        return this.searchClient(passport).getAccount(req);
    }

    private boolean canTransfer(final BankUser.Account account, final double amount) {
        return account.getAmount() >= amount;
    }
}
