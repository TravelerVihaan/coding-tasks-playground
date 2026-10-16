package com.github.vihaan.codewars.kyu4;

/// Kate constantly finds herself in some kind of a maze. Help her to find a way out!.
/// For a given maze and Kate's position find if there is a way out. Your function should return True or False.
///
/// Each maze is defined as a list of strings, where each char stays for a single maze "cell". ' ' (space) can be stepped on, '#' means wall and 'k' stays for Kate's starting position. Note that the maze may not always be square or even rectangular.
///
/// Kate can move left, up, right or down only.
///
/// There should be only one Kate in a maze. In any other case you have to throw an exception.
///
/// Example input
/// ```
/// ['# ##',
/// '# k#',
/// '####']
///
/// ```
///
/// Example output
///
/// `True`
///
/// Example input
/// ```
/// ['####'.
/// '# k#',
/// '####']
/// ```
/// Example output
/// `False`
public class Maze {
    public static boolean hasExit(String[] maze) {
        // Your code here!
        // Throw a RuntimeException if needed.
        return false;
    }
}