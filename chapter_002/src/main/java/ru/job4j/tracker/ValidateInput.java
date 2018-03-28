package ru.job4j.tracker;

import ru.job4j.tracker.interfaces.Input;

/**Этот класс ВТОРАЯ версия класса ConsoleInput. Добавлены Exeptions. (Первоначальная реализация была основана на extends ConsoleInput).
 * Рефакторинг. Теперь класс принимает поле типа Input и имплементирует интерфейс Input. По шаблону Decorator - добавление нового поведения в уже существующее поведение.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 27.03.2018.
 */
public class ValidateInput implements Input {

    private Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
       return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value =  this.input.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid data: ");
            } catch (MenuOutExeption moe) {
                System.out.println("Please select key from menu range: ");
            }
        } while (invalid);
        return value;
    }
}
