package com.github.vihaan.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FourLetterWordsAnagramsTest {

  @Test
  void smallestPossibleTest() {
    String[] subjects = {"apex"},
             alice    = {"apex"},
             bob      = {"beak"},
             carol    = {"cere"},
             dan      = {"defy"};
    String[][] memories = {alice, bob, carol, dan};
    int[] players = {3, 0};
    int expected = 0;
    int submitted = FourLetterWordsAnagrams.anagrams(subjects, memories, players);
    assertEquals(expected, submitted);
  }
  @Test
  void everyoneGoesFirstOnce() {
    String[] subjects = {"alef", "late", "ears", "taws"},
             alice    = {"ares", "ears", "feal", "flea"},
             bob      = {"swat", "taws", "twas", "wats"},
             carol    = {"sear", "leaf", "tale", "teal"},
             dan      = {"eras", "late", "rase", "tael"};
    String[][] memories = {alice, bob, carol, dan};
    int[] players = {2, 1};
    int expected = 1;
    int submitted = FourLetterWordsAnagrams.anagrams(subjects, memories, players);
    assertEquals(expected, submitted);
  }
  @Test
  void completeOrderOfRounds() {
    String[] subjects = {"spam", "tsar", "apse", "swan", "alps", "name", "ales", "last"},
             alice    = {"lats", "rats", "sale", "pals", "swan", "amen", "lase", "salp", "samp", "apes", "pams", "spam", "alps", "peas", "sawn", "tars", "mean", "last", "snaw", "pase", "star", "ales", "alts", "mane", "tsar", "awns", "wans", "slap", "nema", "amps", "spae", "laps"},
             bob      = {"rats", "pams", "slap", "ales", "salt", "snaw", "slat", "apes", "mean", "seal", "alts", "tars", "lase", "wans", "sale", "lats", "mane", "awns", "sawn", "laps", "peas", "amps", "star", "maps", "tsar", "spae", "apse", "swan", "name", "arts", "amen", "spam"},
             carol    = {"nema", "arts", "star", "samp", "laps", "seal", "pals", "apes", "mane", "swan", "lats", "wans", "alts", "slap", "leas", "apse", "sale", "lase", "tars", "rats", "ales", "mean", "salp", "awns", "pams", "tsar", "salt", "amps", "spam", "slat", "name", "pase"},
             dan      = {"last", "name", "ales", "slat", "amen", "pals", "salt", "apse", "star", "peas", "sale", "salp", "slap", "spam", "snaw", "lats", "leas", "awns", "alts", "sawn", "rats", "tsar", "spae", "laps", "amps", "arts", "nema", "wans", "maps", "mean", "swan", "tars"};
    String[][] memories = {alice, bob, carol, dan};
    int[] players = {1, 3};
    int expected = 1;
    int submitted = FourLetterWordsAnagrams.anagrams(subjects, memories, players);
    assertEquals(expected, submitted);
  }
  @Test
  void comprehensiveScenarios() {
    String[] subjects = {"darb", "bust", "spot", "calo", "oaky", "mite", "meta", "tael", "gore", "elan", "code", "demo"},
             alice    = {"bard", "coal", "cola", "dome", "drab", "emit", "ergo", "goer", "gore", "loca", "mode", "okay", "stop", "stub", "tame"},
             bob      = {"buts", "code", "coed", "lean", "leat", "mate", "meat", "post", "pots", "spot", "stop", "stub", "tale", "tame", "tela"},
             carol    = {"brad", "bust", "darb", "ergo", "gore", "item", "lane", "mate", "meta", "ogre", "okay", "tame", "team", "time", "tubs"},
             dan      = {"calo", "coal", "code", "cola", "deco", "demo", "kayo", "late", "mode", "oaky", "opts", "spot", "tale", "teal", "tops"};
    String[][] memories = {alice, bob, carol, dan};
    int[] players = {0, 2};
    int expected = -1;
    int submitted = FourLetterWordsAnagrams.anagrams(subjects, memories, players);
    assertEquals(expected, submitted);
  }
}