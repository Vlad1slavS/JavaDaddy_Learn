package Testing.topic2_Mockito.task2_AuthService;

import io.github.vladislav.Testing.topic2_Mockito.task2_AuthService.forTest.AuthService;
import io.github.vladislav.Testing.topic2_Mockito.task2_AuthService.forTest.User;
import io.github.vladislav.Testing.topic2_Mockito.task2_AuthService.forTest.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Тест для сервиса в сервисе для Авторизации пользователей
 * @author Владислав Степанов
 */
@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private UserRepository userRepository;

    private final String username = "testUser";
    private final String password = "testPass";
    private final String incorrectPassword = "incorrectPass";


    private final User user = new User("testUser", "testPass");

    @Test
    void authenticateUser_successAuth() {
        when(userRepository.findUserByUsername(anyString())).thenReturn(user);
        boolean authenticate = authService.authenticateUser(username, password);

        assertTrue(authenticate);
        verify(userRepository).findUserByUsername(username);
    }

    @Test
    void authenticateUser_incorrectPass_failedAuth() {
        when(userRepository.findUserByUsername(username)).thenReturn(user);
        boolean authenticate = authService.authenticateUser(username, incorrectPassword);
        assertFalse(authenticate);
        verify(userRepository).findUserByUsername(username);
    }

    @Test
    void authenticateUser_userNotFound_failedAuth() {
        when(userRepository.findUserByUsername(username)).thenReturn(null);
        boolean authenticate = authService.authenticateUser(username, password);
        assertFalse(authenticate);
        verify(userRepository).findUserByUsername(username);
    }


}
