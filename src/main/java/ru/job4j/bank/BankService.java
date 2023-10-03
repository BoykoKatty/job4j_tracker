package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (users.get(user) == null) {
            users.put(user, new ArrayList<>());
        }
    }

    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        users.remove(user);
    }

    public void addAccount(String passport, Account account) {
        if (findByRequisite(passport, account.getRequisite()) != null) {
            return;
        }
        User user = findByPassport(passport);
        users.get(user).add(account);
    }

    public User findByPassport(String passport) {
        User ourUser = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                ourUser = user;
                break;
            }
        }
        return ourUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account userAccount = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    userAccount = account;
                }
            }
        }
        return userAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        if (amount <= 0) {
            return false;
        }
        boolean rsl = false;
        Account senderAccount = findByRequisite(srcPassport, srcRequisite);
        Account receiverAccount = findByRequisite(destPassport, destRequisite);
        if (senderAccount != null
                && receiverAccount != null
                && senderAccount.getBalance() >= amount)  {
            senderAccount.setBalance(senderAccount.getBalance() - amount);
            receiverAccount.setBalance(receiverAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}