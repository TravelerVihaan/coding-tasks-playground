package com.github.vihaan.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTimeDiffTest {
    @Test
    public void basicTests(){     
        assertEquals("23:59",SimpleTimeDiff.solve(new String[] {"14:51"}));
        assertEquals("09:10",SimpleTimeDiff.solve(new String[] {"21:14", "15:34", "14:51", "06:25", "15:30"}));
        assertEquals("11:40",SimpleTimeDiff.solve(new String[] {"23:00","04:22","18:05","06:24"}));   
    }
}