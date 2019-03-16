package ru.job4j.banklambda;

import ru.job4j.banklambda.exeptions.NoSuchAccountException;
import ru.job4j.banklambda.interfaces.BankClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BankUser implements BankClient {
    private final String name;
    private final String passport;
    private final Map<String, BankUser.Account> accounts;

    public BankUser(final String name, final String passport) {
        this.name = name;
        this.passport = passport;
        this.accounts = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String getPassport() {
        return this.passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankUser bankUser = (BankUser) o;
        return Objects.equals(passport, bankUser.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return String.format("Name:%s Passport:%s ", this.name, this.passport);
    }

    public String userDetailInfo() {
        return this.getUserAccounts()
                .values()
                .stream()
                .map(Account::toString)
                .collect(Collectors.joining(" ; ", this.toString().concat("["), "]"));
    }

    @Override
    public boolean addAccount(final String req, final double amount) {
        return this.accounts.putIfAbsent(req, this.new Account(req, amount)) == null;
    }

    @Override
    public boolean deleteAccount(final String req) throws NoSuchAccountException {
        if (this.isUserHasAccount(req) && this.accounts.remove(req) != null) {
            return true;
        }
        throw new NoSuchAccountException("No such Account!");
    }

    @Override
    public Map<String, BankUser.Account> getUserAccounts() {
        return this.accounts;
    }

    @Override
    public BankUser.Account getAccount(final String req) throws NoSuchAccountException{
        if (this.isUserHasAccount(req)) {
            return this.accounts.get(req);
        }
        throw new NoSuchAccountException("No such Account!");
    }

    private boolean isUserHasAccount(final String req) {
        return this.accounts.containsKey(req);
    }

    public final class Account {
        private final String requisites;
        private double amount;

        private Account(final String requisites) {
            this.requisites = requisites;
        }

        private Account(final String requisites, final double amount) {
            this(requisites);
            this.amount = amount;
        }

        public double getAmount() {
            return this.amount;
        }

        public String getRequisites() {
            return this.requisites;
        }

        public void setAmount(final double amount) {
            this.amount = amount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Account account = (Account) o;
            return Objects.equals(requisites, account.requisites);
        }

        @Override
        public int hashCode() {
            return Objects.hash(requisites);
        }

        @Override
        public String toString() {
            return String.format("AccReq:%s, AccAmount:%.2f",
                    this.requisites,
                    this.amount);
        }

        public String accDetailedInfo() {
            return String.format("AccHolder: %s, %s", BankUser.this.name, this.toString());
        }
    }
}
