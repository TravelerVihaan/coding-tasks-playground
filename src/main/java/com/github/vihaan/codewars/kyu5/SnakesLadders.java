package com.github.vihaan.codewars.kyu5;

import java.util.HashMap;
import java.util.Map;

/// Snakes and Ladders is an ancient Indian board game regarded today as a worldwide classic.
/// It is played by two or more players on a game board with numbered, gridded squares.
/// A number of "ladders" and "snakes" are pictured on the board, each connecting two specific squares. (Source: Wikipedia)
///
/// Your task is to create a simple class called SnakesLadders.
/// The test cases will call the method play(die1, die2) independently of the state of the game or the player turn.
/// The arguments die1 and die2 are the dice thrown in a turn and are both integers between 1 and 6.
/// The player will make a number of steps equal to the sum of die1 and die2, moving one square per step.
///
/// LADDERS:
///     2 -> 38
///     7 -> 14
///     8 -> 31
///     15 -> 26
///     21 -> 42
///     28 -> 84
///     36 -> 44
///     51 -> 67
///     71 -> 91
///     78 -> 98
///     87 -> 94
/// SNAKES:
///     16 -> 6
///     46 -> 25
///     49 -> 11
///     62 -> 19
///     64 -> 60
///     74 -> 53
///     89 -> 68
///     92 -> 88
///     95 -> 75
///     99 -> 80
///
/// Rules
///
///  1. There are two players, and both start off the board on square 0.
///  2. Player 1 starts and alternates with player 2.
///  3. You follow the numbers up the board in order from 1 to 100.
///  4. If the values of both dice are the same, that player will have another turn after the current turn ends.
///  5. Climb up ladders. The ladders on the game board allow you to move upwards and get ahead faster. If you land exactly on a square that shows the bottom of a ladder, you may move the player all the way up to the square at the top of the ladder (even if you roll a double).
///  6. Slide down snakes. Snakes move you back on the board. If you land exactly on the top of a snake, you must slide all the way down to the square at the bottom of the snake or chute (even if you roll a double).
///  7. Land exactly on the last square to win. The first player to reach the highest square on the board wins. If you roll too high, your player "bounces" off square 100 and continues moving backward for the remaining steps. You can only win by rolling the exact number needed to land on the last square. For example, if you are on square 98 and roll a five, move your piece to 100 (two steps), then "bounce" back to 99, 98, and 97 (three, four, then five steps).
///  8. If the player rolls a double and lands on the finish square (100) after taking all steps for the roll, the player wins the game and does not take another turn.
///
/// Returns
///
/// Return "Player n Wins!" where n is the winning player who has landed on square 100 after taking all steps in their turn.
///
/// Return "Game over!" if a move is attempted after any player has won.
///
/// Otherwise, return "Player n is on square x", where n is the current player and x is the square they are currently on.
public class SnakesLadders {
    private final Map<Integer, Integer> fields;
    private final Map<Integer, Integer> players;
    private int currentPlayer;
    private int winner = 0;

    public SnakesLadders() {
        fields = setUpSnakesAndLadders();

        players = new HashMap<>();
        players.put(1, 0);
        players.put(2, 0);

        currentPlayer = 1;
    }

    public String play(int die1, int die2) {
        if (winner != 0) {
            return "Game over!";
        }

        int playerField = players.get(currentPlayer);
        playerField += die1 + die2;
        playerField = handleWinningFieldIfApplicable(playerField);
        if (playerField == 100) {
            winner = currentPlayer;
        }
        playerField = fields.getOrDefault(playerField, playerField);
        players.replace(currentPlayer, playerField);


        if (winner != 0 && winner == currentPlayer) {
            return "Player %d Wins!".formatted(currentPlayer);
        }

        String outputMessage = "Player %d is on square %d".formatted(currentPlayer, playerField);

        if (die1 != die2) {
            switchPlayer();
        }

        return outputMessage;
    }

    private void switchPlayer() {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        } else {
            currentPlayer = 1;
        }
    }

    private int handleWinningFieldIfApplicable(int playerField) {
        if (playerField > 100) {
            return 100 - (playerField - 100);
        }
        return playerField;
    }

    private static Map<Integer, Integer> setUpSnakesAndLadders() {
        return Map.ofEntries(
            Map.entry(99, 80), Map.entry(95, 75), Map.entry(92, 88), Map.entry(89, 68),
            Map.entry(74, 53), Map.entry(64, 60), Map.entry(62, 19), Map.entry(49, 11),
            Map.entry(46, 25), Map.entry(16, 6), // snakes
            Map.entry(2, 38), Map.entry(7, 14), Map.entry(8, 31), Map.entry(15, 26),
            Map.entry(21, 42), Map.entry(28, 84), Map.entry(36, 44), Map.entry(51, 67),
            Map.entry(71, 91), Map.entry(78, 98), Map.entry(87, 94) // ladders
        );
    }
}