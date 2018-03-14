package ru.job4j.condition;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 14.03.2018.
 */

public class DummyBot {
    /**
     * Отвечает на вопросы.
     */
    public String answer(String question) {
        String result = "";

        if (question.equals("Привет, Бот")) {
            result = "Привет, умник";
        } else if (question.equals("Пока")) {
            result = "До скорой встречи";
        } else {
            result = "Это ставит меня в тупик. Спросите другой вопрос";
        }
        return result;
    }
}
