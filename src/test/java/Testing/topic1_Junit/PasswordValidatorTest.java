package Testing.topic1_Junit;

import io.github.vladislav.Testing.topic1_Junit.PasswordValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest {

    @Test
    public void isValid_validPassword_returnsTrue() {
        String password = "Password1";
        assertTrue(PasswordValidator.isValid(password));
    }

    @Test
    public void isValid_shortPassword_returnsFalse() {
        String password = "Pass1";
        assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    public void isValid_noDigitPassword_returnsFalse() {
        String password = "Password";
        assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    public void isValid_emptyPassword_returnsFalse() {
        String password = "";
        assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    public void isValid_nullPassword_returnsFalse() {
        String password = null;
        assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    public void isValid_passwordWithSpecialChars_returnsTrue() {
        String password = "2----!!!!??";
        assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    public void isValid_passwordWithSpaces_returnsTrue() {
        String password = "1         ";
        assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    public void isValid_passwordWithOnlyDigits_returnsTrue() {
        String password = "12345678";
        assertTrue(PasswordValidator.isValid(password));
    }

}
