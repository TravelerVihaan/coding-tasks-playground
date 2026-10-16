package com.github.vihaan.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeEgyptianFractionsTest {

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        testing(SomeEgyptianFractions.decompose("3", "4"), "[1/2, 1/4]");
        testing(SomeEgyptianFractions.decompose("12", "4"), "[3]");
        testing(SomeEgyptianFractions.decompose("0", "2"), "[]");
        testing(SomeEgyptianFractions.decompose("9", "10"), "[1/2, 1/3, 1/15]");
    }

    @Test
    public void test2() {
        assertEquals("[1/2, 1/4]",              SomeEgyptianFractions.decompose("3", "4"));
        assertEquals("[3]",                      SomeEgyptianFractions.decompose("12", "4"));
        assertEquals("[]",                       SomeEgyptianFractions.decompose("0", "2"));
        assertEquals("[1/2, 1/3, 1/15]",         SomeEgyptianFractions.decompose("9", "10"));
        assertEquals("[1/2, 1/3, 1/13, 1/359, 1/644046]",
            SomeEgyptianFractions.decompose("21", "23"));
        assertEquals("[1/2, 1/6]",               SomeEgyptianFractions.decompose("2", "3"));
    }
}