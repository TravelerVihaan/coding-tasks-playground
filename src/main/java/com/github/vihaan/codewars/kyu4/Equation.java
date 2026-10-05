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
        String[] parts = equation.split("(?=[+-])");
        BigInteger result = BigInteger.ZERO;

        for (String part : parts) {
                if (part.contains("x^")) {
                    var temp = part.split("x\\^");
                    var power = Integer.parseInt(temp[1]);

                    var multiplier = ("".equals(temp[0]) || "-".equals(temp[0]) ?
                        temp[0].contains("-") ? -1 : 1
                        : Long.parseLong(temp[0])) * power;
                    power = power - 1;
                    var partResult = BigInteger.valueOf(x).pow(power).multiply(BigInteger.valueOf(multiplier));
                    result = result.add(partResult);
                } else if (part.contains("x")) {

                    var multiplier = Long.parseLong(part.startsWith("x") || part.startsWith("-x") ? part.replace("x", "1") : part.replace("x", ""));
                    result = result.add(BigInteger.valueOf(multiplier));
                }

        }
        return result;
    }
}