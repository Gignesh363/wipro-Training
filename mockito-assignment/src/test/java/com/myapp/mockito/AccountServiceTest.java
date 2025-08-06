package com.myapp.mockito;

import com.myapp.mockito.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    private AccountRepository accountRepository;
    private NotificationService notificationService;
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);
        notificationService = mock(NotificationService.class);
        accountService = new AccountService(accountRepository, notificationService);
    }

    @Test
    void testSuccessfulTransfer() {
        Account fromAccount = new Account("A1", 1000);
        Account toAccount = new Account("A2", 500);

        when(accountRepository.findById("A1")).thenReturn(fromAccount);
        when(accountRepository.findById("A2")).thenReturn(toAccount);

        boolean result = accountService.transfer("A1", "A2", 200);

        assertTrue(result);
        assertEquals(800, fromAccount.getBalance());
        assertEquals(700, toAccount.getBalance());

        verify(accountRepository, times(2)).update(any(Account.class));
        verify(notificationService, times(1))
                .send("A1", "Transferred 200.0 to A2");
    }

    @Test
    void testFailedTransfer_InsufficientBalance() {
        Account fromAccount = new Account("A1", 100);
        Account toAccount = new Account("A2", 500);

        when(accountRepository.findById("A1")).thenReturn(fromAccount);
        when(accountRepository.findById("A2")).thenReturn(toAccount);

        boolean result = accountService.transfer("A1", "A2", 200);

        assertFalse(result);
        verify(accountRepository, never()).update(any(Account.class));
        verify(notificationService, never()).send(anyString(), anyString());
    }

    @Test
    void testFailedTransfer_AccountNotFound() {
        when(accountRepository.findById("A1")).thenReturn(null);
        when(accountRepository.findById("A2")).thenReturn(new Account("A2", 500));

        boolean result = accountService.transfer("A1", "A2", 100);

        assertFalse(result);
        verify(accountRepository, never()).update(any(Account.class));
        verify(notificationService, never()).send(anyString(), anyString());
    }
}
