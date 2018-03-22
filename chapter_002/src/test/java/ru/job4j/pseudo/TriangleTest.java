package ru.job4j.pseudo;
import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 22.03.2018.
 */
public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.pic(),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   +   ")
                                .add("  +++  ")
                                .add(" +++++ ")
                                .add("+++++++")
                                .toString()
                )
        );
    }
}
