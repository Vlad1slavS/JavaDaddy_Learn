package Testing.topic1_Junit;

import io.github.vladislav.Testing.topic1_Junit.WordCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void countWords_validInput_correctCount() {
        String text = "Привет мир это тест";
        assertEquals(4, WordCounter.countWords(text));
    }

    @Test
    public void countWords_moreOneSpace_correctCount() {
        String text = "Привет    мир это тест";
        assertEquals(4, WordCounter.countWords(text));
    }

    @Test
    public void countWords_emptyString_ZeroCount() {
        String text = "";
        assertEquals(0, WordCounter.countWords(text));
    }

    @Test
    public void countWords_tabulationAndLineBreak_correctCount() {
        String text = "asd\tasd\nasdasd";
        assertEquals(3, WordCounter.countWords(text));
    }

    @Test
    public void countWords_onlySpaces_ZeroCount() {
        String text = "     ";
        assertEquals(0, WordCounter.countWords(text));
    }

}
