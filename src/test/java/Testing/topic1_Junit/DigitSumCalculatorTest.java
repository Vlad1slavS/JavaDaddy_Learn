package Testing.topic1_Junit;

import io.github.vladislav.Testing.topic1_Junit.DigitSumCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitSumCalculatorTest {

    @Test
    public void sumDigits_validInput_correctSum() {
        int input = 12345;
        assertEquals(15, DigitSumCalculator.sumDigits(input));
    }

    @Test
    public void sumDigits_singleDigitNumber_correctSum() {
        int input = 2;
        assertEquals(2, DigitSumCalculator.sumDigits(input));
    }

    @Test
    public void sumDigits_negativeNumber_correctSum() {
        int input = -12345;
        assertEquals(13, DigitSumCalculator.sumDigits(input));
    }

    @Test
    public void sumDigits_negativeNumber2_correctSum() {
        int input = -49;
        assertEquals(5, DigitSumCalculator.sumDigits(input));
    }

    @Test
    public void sumDigits_zeroNumber_zeroSum() {
        int input = 0;
        assertEquals(0, DigitSumCalculator.sumDigits(input));
    }

}
