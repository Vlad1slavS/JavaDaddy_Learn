package Testing.topic1_Junit;

import io.github.vladislav.Testing.topic1_Junit.MaxFinder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MaxFinderTest {

    @Test
    public void findMax_validInput_correctMax() {
        int[] numbers = {1, 3, 2, 5, 4};
        assertEquals(5, MaxFinder.findMax(numbers).isPresent() ?
                MaxFinder.findMax(numbers).getAsInt() :
                null);
    }

    @Test
    public void findMax_IntegerMinValueIncluded_correctMax() {
        int[] numbers = {Integer.MIN_VALUE};
        assertEquals(Integer.MIN_VALUE, MaxFinder.findMax(numbers).isPresent() ?
                MaxFinder.findMax(numbers).getAsInt() :
                null);
    }

    @Test
    public void findMax_validInputFirst_correctMax() {
        int[] numbers = {5, 3, 2, 1, 4};
        assertEquals(5, MaxFinder.findMax(numbers).isPresent() ?
                MaxFinder.findMax(numbers).getAsInt() :
                null);
    }

    @Test
    public void findMax_oneElement_correctMax() {
        int[] numbers = {42};
        assertEquals(42, MaxFinder.findMax(numbers).isPresent() ?
                MaxFinder.findMax(numbers).getAsInt() :
                null);
    }

    @Test
    public void findMax_negativeNumbers_correctMax() {
        int[] numbers = {-1, -3, -2, -5, -4};
        assertEquals(-1, MaxFinder.findMax(numbers).isPresent() ?
                MaxFinder.findMax(numbers).getAsInt() :
                null);
    }

    @Test
    public void findMax_emptyArray_throwsException() {
        int[] numbers = {};
        assertNull(MaxFinder.findMax(numbers).isPresent() ?
                MaxFinder.findMax(numbers).getAsInt() :
                null);
    }

    @Test
    public void findMax_nullArray_throwsException() {
        int[] numbers = null;
        assertNull(MaxFinder.findMax(numbers).isPresent() ?
                MaxFinder.findMax(numbers).getAsInt() :
                null);
    }

    @Test
    public void findMax_repeatNumbers_throwsException() {
        int[] numbers = {2, 2, 2, 2};
        assertEquals(2, MaxFinder.findMax(numbers).isPresent() ?
                MaxFinder.findMax(numbers).getAsInt() :
                null);
    }

}
