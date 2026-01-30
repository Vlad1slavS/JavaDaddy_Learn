package Testing.topic2_Mockito.task3_AccountService;

import io.github.vladislav.Testing.topic2_Mockito.task3_AccountService.forTest.Account;
import io.github.vladislav.Testing.topic2_Mockito.task3_AccountService.forTest.AccountRepository;
import io.github.vladislav.Testing.topic2_Mockito.task3_AccountService.forTest.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Тест для сервиса в сервисе для Управления балансом счета
 * @author Владислав Степанов
 */
@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    private final Account account = new Account("TestID", 1000);

    @Test
    void withdraw_successful() {
        when(accountRepository.findAccountById("TestID")).thenReturn(account);
        accountService.withdraw("TestID", 1000);

        verify(accountRepository).updateAccount(account);
    }

    @Test
    void withdraw_insufficientFunds() {
        when(accountRepository.findAccountById("TestID")).thenReturn(account);
        boolean isWithdraw = accountService.withdraw("TestID", 1500);
        assertFalse(isWithdraw);

        verify(accountRepository, never()).updateAccount(account);
        verify(accountRepository).findAccountById("TestID");
    }

    @Test
    void withdraw_userNotFound() {
        when(accountRepository.findAccountById("TestID")).thenReturn(null);
        boolean isWithdraw = accountService.withdraw("TestID", 1500);
        assertFalse(isWithdraw);

        verify(accountRepository, never()).updateAccount(account);
        verify(accountRepository).findAccountById("TestID");
    }



}
