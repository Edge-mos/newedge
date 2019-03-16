package ru.job4j.funcinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;

public class CalcRange {

    public List<Double> range(int start, int finish, Function<Double, Double> op) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < finish; i++) {
            result.add(op.apply((double)i));
        }
        return result;
    }
}
