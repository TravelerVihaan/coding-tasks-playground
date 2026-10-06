package com.github.vihaan.codewars.kyu4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitCountTest {

    @Test
    public void sampleTests() {
        assertEquals(new BigInteger("7"), BitCount.countOnes(8294832867632L,14993374709020L));
        assertEquals(new BigInteger("7"), BitCount.countOnes(5,7));
        assertEquals(new BigInteger("51"), BitCount.countOnes(12,29));
    }

    @Test
    @Timeout(value = 16, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    public void largeNumbers() {
        assertEquals(new BigInteger("7"), BitCount.countOnes(8294832867632L,14993374709020L));
    }
}