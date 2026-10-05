package com.github.vihaan.codewars.kyu4;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquationTest {

    @Test
    public void sampleTests() {
        assertEquals(new BigInteger("-607427058807635784217"),  Equation.differentiate("-32x^6-61x^5+91x^4+81x^3+85x^2-17x+14", 5012));
        assertEquals(new BigInteger("12"),  Equation.differentiate("12x+2", 3));
        assertEquals(new BigInteger("5"),   Equation.differentiate("x^2-x", 3));
        assertEquals(new BigInteger("-20"), Equation.differentiate("-5x^2+10x+4", 3));
    }
}