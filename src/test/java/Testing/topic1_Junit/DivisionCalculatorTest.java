package Testing.topic1_Junit;

import io.github.vladislav.Testing.topic1_Junit.DivisionCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тест 1 – Проверка деления
 * @author Владислав Степанов
 */
public class DivisionCalculatorTest {

    @Test
    public void divide_validInput_noExceptionThrown() {
        assertEquals(2.0, DivisionCalculator.divide(4, 2));
    }

    @Test
    public void divide_divideByZero_noExceptionThrown() {
        assertEquals(Double.POSITIVE_INFINITY, DivisionCalculator.divide(5, 0));
    }

    @Test
    public void divide_non_integer_doubleResult() {
        assertEquals(2.5, DivisionCalculator.divide(5, 2));
    }

    @Test
    public void divide_negativeNumbers_noExceptionThrown() {
        assertEquals(2.0, DivisionCalculator.divide(-4, -2));
    }

    @Test
    public void divide_positiveAndNegativeNumbers_noExceptionThrown() {
        assertEquals(-2.0, DivisionCalculator.divide(4, -2));
    }
}
