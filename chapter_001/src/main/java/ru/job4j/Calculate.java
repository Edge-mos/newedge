package ru.job4j;
/**
 * Class-wrapper for demonstration most popular and first-ever
 * programm in the world.
 * @author vyamnikov.
 * @since 08.03.2018.
 * @version 2.0.
 */
public class Calculate {
    /**
     *Main.
     *@param args - args.
     */
    public static void main(final String[] args) {
        System.out.println("Hello World!");
    }
    /**
     *Method echo.
     *@param name Your name.
     *@return Echo plus your name.
     */
    public final String echo(final String name) {
        return "Echo, echo, echo : " + name;
    }
}
