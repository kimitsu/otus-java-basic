package ru.otus.java.basic.hw22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class IntArrayProcessorTest {

    @ParameterizedTest
    @MethodSource("getTrimmedUntilLastOneTestData")
    void getTrimmedUntilLastOne(int[] array, int[] result, boolean shouldThrow) {
        if (shouldThrow) {
            Assertions.assertThrowsExactly(RuntimeException.class, () -> IntArrayProcessor.getTrimmedUntilLastOne(array));
        } else {
            Assertions.assertArrayEquals(result, IntArrayProcessor.getTrimmedUntilLastOne(array));
        }
    }

    static Stream<Arguments> getTrimmedUntilLastOneTestData() {
        List<Arguments> data = new ArrayList<>();
        data.add(Arguments.arguments(new int[]{}, new int[]{}, true));
        data.add(Arguments.arguments(new int[]{3, 2, 1}, new int[]{}, false));
        data.add(Arguments.arguments(new int[]{-1, 2, 1, 3, 4, 5}, new int[]{3, 4, 5}, false));
        data.add(Arguments.arguments(new int[]{-1, 2, 1, 3, 1, 1, 5, 4, 3}, new int[]{5, 4, 3}, false));
        data.add(Arguments.arguments(new int[]{-1, 2, -1, 3, -1, -1, 5, 4, 3}, new int[]{}, true));
        return data.stream();
    }

    @Test
    void isArrayContainsOnesAndTwosOnly() {
        Assertions.assertEquals(false, IntArrayProcessor.isArrayContainsOnesAndTwosOnly(new int[]{}));
        Assertions.assertEquals(true, IntArrayProcessor.isArrayContainsOnesAndTwosOnly(new int[]{1}));
        Assertions.assertEquals(true, IntArrayProcessor.isArrayContainsOnesAndTwosOnly(new int[]{2}));
        Assertions.assertEquals(true, IntArrayProcessor.isArrayContainsOnesAndTwosOnly(new int[]{1, 1, 2, 2}));
        Assertions.assertEquals(false, IntArrayProcessor.isArrayContainsOnesAndTwosOnly(new int[]{1, 1, 3, 2}));
        Assertions.assertEquals(false, IntArrayProcessor.isArrayContainsOnesAndTwosOnly(new int[]{3, 1, 1, 1}));
    }
}
