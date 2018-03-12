package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test.
 *
 *@author Vladimir Yamnikov (Androedge@gmail.com).
 *@version $2$.
 *@since 09.03.2018.
 */
public class CalculateTest {
  /**
   *Test echo.
   */
  @Test
  public void whenTakeNameThenThreeEchoPlusName() {
    String input = "Vladimir Yamnikov";
    String expect = "Echo, echo, echo : Vladimir Yamnikov";
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));

  }

}
