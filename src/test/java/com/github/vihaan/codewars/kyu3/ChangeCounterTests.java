package com.github.vihaan.codewars.kyu3;

import com.github.vihaan.codewars.kyu4.ChangeCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeCounterTests {

	@Test
	public void SampleTests() {
    assertEquals(3, ChangeCounter.countChange(4,  new int[] {1,2}));
    assertEquals(4, ChangeCounter.countChange(10, new int[] {5,2,3}));
    assertEquals(0, ChangeCounter.countChange(11, new int[] {5,7}));
    assertEquals(1, ChangeCounter.countChange(0,  new int[] {1,2}));
  }
}