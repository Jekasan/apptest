package ru.test;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestTest {
    private Test test;
    @ParameterizedTest
    @MethodSource("dataCheck")
    public void testCheck(List<Integer> array, boolean result) {
        Assertions.assertEquals(test.check(array), result);
    }

    public static Stream<Arguments> dataCheck() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(List.of(1, 2), true));
        out.add(Arguments.arguments(List.of(1, 1), false));
        out.add(Arguments.arguments(List.of(1, 3), false));
        out.add(Arguments.arguments(List.of(1, 2, 2, 1), true));
        return out.stream();
    }
    @ParameterizedTest
    @MethodSource("testModifyThrow")
    public void testModifyThrow(List<Integer> array) {
        Assertions.assertThrows(RuntimeException.class, () -> test.modify(array));
    }
    public static Stream<Arguments> testModifyThrow() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(List.of(2, 2, 2, 2)));
        return out.stream();
    }
}