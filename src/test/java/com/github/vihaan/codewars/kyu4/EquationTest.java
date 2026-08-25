package com.github.vihaan.codewars.kyu4;

import com.github.vihaan.util.UnfinishedTask;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UnfinishedTask
public class EquationTest {
    @Test
    public void sampleTests() {
        assertEquals(new BigInteger("12"),  Equation.differentiate("12x+2", 3));
        assertEquals(new BigInteger("5"),   Equation.differentiate("x^2-x", 3));
        assertEquals(new BigInteger("-20"), Equation.differentiate("-5x^2+10x+4", 3));
    }
}