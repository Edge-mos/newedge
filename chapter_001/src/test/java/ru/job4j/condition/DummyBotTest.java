package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 14.03.2018.
 */

public class DummyBotTest {
    @Test
    public void whenGreetBot() {
        DummyBot dm = new DummyBot();
        assertThat(dm.answer("Привет, Бот"), is("Привет, умник"));
    }

    @Test
    public void whenByeBot() {
        DummyBot dm = new DummyBot();
        assertThat(dm.answer("Пока"), is("До скорой встречи"));
    }

    @Test
    public void whenUnknownBot() {
        DummyBot dm = new DummyBot();
        assertThat(dm.answer("Сколько будет 2 + 2 ?"), is("Это ставит меня в тупик. Спросите другой вопрос"));
    }
}
