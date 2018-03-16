package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 16.03.2018.
 */


public class StringInWordTest {
    @Test
    public void whenSubstringInStringThenTrue() {
        StringInWord stringInWord = new StringInWord();
        boolean result = stringInWord.contains("Привет", "иве");
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubstringNotInStringThenFalse() {
        StringInWord stringInWord = new StringInWord();
        boolean result = stringInWord.contains("Привет", "рие");
        boolean expected = false;
        assertThat(result, is(expected));
    }
}
