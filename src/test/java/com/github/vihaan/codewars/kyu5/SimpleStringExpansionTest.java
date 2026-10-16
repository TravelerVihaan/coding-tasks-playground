package com.github.vihaan.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleStringExpansionTest{    
    @Test
    public void basicTests(){     
        assertEquals("ababab",SimpleStringExpansion.solve("3(ab)"));
        assertEquals("abbbabbb",SimpleStringExpansion.solve("2(a3(b))"));
        assertEquals("bccbccbcc",SimpleStringExpansion.solve("3(b(2(c)))"));
        assertEquals("kabaccbaccbacc",SimpleStringExpansion.solve("k(a3(b(a2(c))))"));   
    }
}