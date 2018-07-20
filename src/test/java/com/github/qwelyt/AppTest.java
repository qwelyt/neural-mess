package com.github.qwelyt;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        List<Integer> collect = Stream.iterate(0, n -> n + 1).limit(20).collect(Collectors.toList());
        System.err.println(collect);
        assertTrue(true);
    }
}
