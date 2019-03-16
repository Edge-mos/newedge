package ru.job4j.funcinterfaces;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.log;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class CalcRangeTest {

    private CalcRange calcRange;

    @Before
    public void setup() {
        this.calcRange = new CalcRange();
    }
    @Test
    public void whenLinearFuncThanLinearResult() {
        List<Double> expected = new ArrayList<>(Arrays.asList(11D, 13D, 15D));
        List<Double> result = this.calcRange.range(5, 8,
                operand -> 2 * operand + 1);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPowFuncThanPowResult() {
        List<Double> expected = new ArrayList<>(Arrays.asList(25D, 36D, 49D));
        List<Double> result = this.calcRange.range(5, 8,
                operand -> pow(operand, 2));
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFuncThanLogResult() {
        List<Double> expected = new ArrayList<>(Arrays.asList(1.6D, 1.7D, 1.9D));
        final double error = 0.1;
        List<Double> result = this.calcRange.range(5, 8,
                operand -> log(operand));
        System.out.println(result);
        assertThat(result.get(0), closeTo(expected.get(0), error));
        assertThat(result.get(1), closeTo(expected.get(1), error));
        assertThat(result.get(2), closeTo(expected.get(2), error));
    }

}