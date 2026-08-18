package com.github.vihaan.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakesLaddersTest {

    @Test
    public void exampleTests() {
        SnakesLadders game = new SnakesLadders();
        assertEquals("Player 1 is on square 38", game.play(1, 1));
        assertEquals("Player 1 is on square 44", game.play(1, 5));
        assertEquals("Player 2 is on square 31", game.play(6, 2));
        assertEquals("Player 1 is on square 25", game.play(1, 1));
    }
}