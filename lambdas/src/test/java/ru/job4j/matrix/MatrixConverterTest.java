package ru.job4j.matrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixConverterTest {
    private Integer[][] matrix = {
            {1, 2, 3},
            {4, 5, 6, 7},
            {8, 9}
    };

    @Test
    public void wnenDoubleArrayConvertedToList() {
        List<Integer> result = MatrixConverter.matrixConvert(this.matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result, is(expected));
    }

}