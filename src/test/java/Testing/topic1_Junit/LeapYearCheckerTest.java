package Testing.topic1_Junit;

import io.github.vladislav.Testing.topic1_Junit.LeapYearChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeapYearCheckerTest {

    @Test
    public void isLeapYear_validLeapYear_true() {
        assertTrue(LeapYearChecker.isLeapYear(2020));
    }

    @Test
    public void isLeapYear_multiple_100_not_400_false() {
        assertFalse(LeapYearChecker.isLeapYear(2100));
    }

    @Test
    public void isLeapYear_usualYear_false() {
        assertFalse(LeapYearChecker.isLeapYear(2026));
    }

    @Test
    public void isLeapYear_multiple_400_true() {
        assertTrue(LeapYearChecker.isLeapYear(1600));
    }


}
