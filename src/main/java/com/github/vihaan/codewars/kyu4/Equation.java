package com.github.vihaan.codewars.kyu4;

import java.math.BigInteger;

/// Create a function that differentiates a polynomial for a given value of x.
///
/// Your function will receive 2 arguments: a polynomial as a string, and a point to evaluate the equation as an integer.
/// Assumptions:
///
/// There will be a coefficient near each `x`, unless the coefficient equals `1` or `-1`.
///     There will be an exponent near each `x`, unless the exponent equals `0` or `1`.
///     All exponents will be greater or equal to zero
///
/// Examples:
///```
/// Equation.differenatiate("12x+2", 3)      ==>   12
/// Equation.differenatiate("x^2+3x+2", 3)   ==>   9```
public class Equation {
    
    public static BigInteger differentiate(String equation, long x) {
        // Your code here!
        return null;
    }
}