package com.github.vihaan.codewars.kyu3;

import com.github.vihaan.util.UnfinishedTask;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UnfinishedTask
@Disabled("Unfinished coding task")
public class AnagramTest {

  @Test
  public void testKnownInputs() {
    Anagrams anagram = new Anagrams();
    
    assertEquals(BigInteger.ONE, anagram.listPosition("A"), "Position for 'A' incorrect");
    assertEquals(BigInteger.valueOf(2), anagram.listPosition("ABAB"), "Position for 'ABAB' incorrect");
    assertEquals(BigInteger.ONE, anagram.listPosition("AAAB"), "Position for 'AAAB' incorrect");
    assertEquals(BigInteger.valueOf(4), anagram.listPosition("BAAA"), "Position for 'BAAA' incorrect");
    assertEquals(BigInteger.valueOf(24572), anagram.listPosition("QUESTION"), "Position for 'QUESTION' incorrect");
    assertEquals(BigInteger.valueOf(10743), anagram.listPosition("BOOKKEEPER"), "Position for 'BOOKKEEPER' incorrect");
  }
}
