package ru.job4j.tracker;
/**Этот класс ВТОРАЯ версия класса ConsoleInput. Добавлены Exeptions.
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 27.03.2018.
 */
public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value =  super.ask(question, range);
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
