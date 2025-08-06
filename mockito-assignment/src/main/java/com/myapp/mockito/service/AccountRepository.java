package com.myapp.mockito.service;

public interface AccountRepository {
    Account findById(String id);
    void update(Account account);
}
