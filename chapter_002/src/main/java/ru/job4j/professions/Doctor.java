package ru.job4j.professions;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 16.03.2018.
 */



public class Doctor extends Profession {

    public Diagnose heal(Pacient pacient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }
}
