package com.myapp.mockito.service;

public class AccountService {

    private final AccountRepository accountRepository;
    private final NotificationService notificationService;

    public AccountService(AccountRepository accountRepository, NotificationService notificationService) {
        this.accountRepository = accountRepository;
        this.notificationService = notificationService;
    }

    public boolean transfer(String fromId, String toId, double amount) {
        Account fromAccount = accountRepository.findById(fromId);
        Account toAccount = accountRepository.findById(toId);

        if (fromAccount == null || toAccount == null) {
            return false; // account not found
        }

        if (fromAccount.getBalance() < amount) {
            return false; // insufficient balance
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.update(fromAccount);
        accountRepository.update(toAccount);

        notificationService.send(fromId, "Transferred " + amount + " to " + toId);

        return true;
    }
}
