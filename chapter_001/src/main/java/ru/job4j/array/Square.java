package ru.job4j.array;
import static java.lang.Math.pow;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 15.03.2018.
 */

public class Square {
//    public double[] calculate(int bound) {
//        double[] result = new double[bound];
//
//        for (int i = 0; i < bound ; i++) {
//            result[i] = pow(i + 1, 2);
//        }
//        return result;
//    }

    public int[] calculate(int bound) {
        int[] result = new int[bound];

        for (int i = 0; i <  bound; i++) {
            result[i] = (i + 1) * (i + 1);
        }
        return result;
    }
}
