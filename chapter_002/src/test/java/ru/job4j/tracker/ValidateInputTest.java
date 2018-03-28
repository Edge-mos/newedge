package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import ru.job4j.tracker.interfaces.Input;
import ru.job4j.tracker.models.Item;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 28.03.2018.
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {

        ValidateInput input = new ValidateInput(new StubInput(new String[] {"aFaf", "1"}));
        input.ask("Select option: ", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please enter valid data: \n")
                )
        );
    }

    @Test
    public void whenInvalidRange() {

        ValidateInput input = new ValidateInput(new StubInput(new String[] {"8", "1"}));
        input.ask("Select option: ", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please select key from menu range: \n")
                )
        );
    }
}


