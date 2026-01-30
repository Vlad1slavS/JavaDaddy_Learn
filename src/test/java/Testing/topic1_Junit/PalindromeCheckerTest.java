package Testing.topic1_Junit;

import io.github.vladislav.Testing.topic1_Junit.PalindromeChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeCheckerTest {

    @Test
    public void isPalindrome_validPalindrome_returnTrue() {
        assertTrue(PalindromeChecker.isPalindrome("madam"));
    }

    @Test
    public void isPalindrome_emptyString_returnTrue() {
        assertTrue(PalindromeChecker.isPalindrome(""));
    }

    @Test
    public void isPalindrome_nullString_returnFalse() {
        assertFalse(PalindromeChecker.isPalindrome(null));
    }

    @Test
    public void isPalindrome_stringWithSpace_returnFalse() {
        assertTrue(PalindromeChecker.isPalindrome("  madam"));
    }

    @Test
    public void isPalindrome_upperCase_returnTrue() {
        assertTrue(PalindromeChecker.isPalindrome("Madam"));
    }

    @Test
    public void isPalindrome_stringWithSpacesInside_returnTrue() {
        assertTrue(PalindromeChecker.isPalindrome("Ma dam"));
    }

}
