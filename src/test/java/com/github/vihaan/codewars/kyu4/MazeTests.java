package com.github.vihaan.codewars.kyu4;

import com.github.vihaan.util.UnfinishedTask;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@UnfinishedTask
@Disabled("Unfinished coding task")
public class MazeTests {

    @ParameterizedTest(name = "{2}")
    @MethodSource("config")
    void test(String[] maze, boolean exp, String name, boolean error) {
        if (error) {
            assertThrows(RuntimeException.class, () -> Maze.hasExit(Arrays.copyOf(maze, maze.length)),
                    "Your code should throw a RuntimeException when there isn't exactly one Kate");
        } else {
            assertEquals(exp, Maze.hasExit(Arrays.copyOf(maze, maze.length)));
        }
    }

    static Stream<Arguments> config() {
        return Stream.of(
            Arguments.of(
                new String[] {"k"}, true, "Simple tests - simplest case", false),
            Arguments.of(
                new String[] {"###",
                              "#k#",
                              "###"}, false, "Simple tests - no exit case", false),
            Arguments.of(
                new String[] {"###",
                              "#k ",
                              "###"}, true, "Simple tests - single exit case", false),
            Arguments.of(
                new String[] {"k ",
                              "kk"}, false, "Simple tests - There should be no multiple Kates", true),
            Arguments.of(
                new String[] {"########",
                              "# # ####",
                              "# #k#   ",
                              "# # # ##",
                              "# # # ##",
                              "#      #",
                              "########"}, true, "More difficult cases - single exit big maze", false),
            Arguments.of(
                new String[] {"########",
                              "# # ## #",
                              "# #k#  #",
                              "# # # ##",
                              "# # #  #",
                              "#     ##",
                              "########"}, false, "no exit big maze", false)
        );
    }
}