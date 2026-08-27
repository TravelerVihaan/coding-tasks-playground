package com.github.vihaan.codewars.kyu4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/// Motivation
/// When compressing sequences of symbols, it is useful to have many equal symbols follow each other, because then they can be encoded with a run length encoding. For example, RLE encoding of "aaaabbbbbbbbbbbcccccc" would give something like 4a 11b 6c.
///
/// (Look here for learning more about the run-length-encoding.)
///
/// Of course, RLE is interesting only if the string contains many identical consecutive characters. But what bout human readable text? Here comes the Burrows-Wheeler-Transformation.
///
/// Transformation
/// There even exists a transformation, which brings equal symbols closer together, it is called the Burrows-Wheeler-Transformation. The forward transformation works as follows: Let's say we have a sequence with length n, first write every shift of that string into a n x n matrix:
///
/// ```
/// Input: "bananabar"
///
/// b a n a n a b a r
/// r b a n a n a b a
/// a r b a n a n a b
/// b a r b a n a n a
/// a b a r b a n a n
/// n a b a r b a n a
/// a n a b a r b a n
/// n a n a b a r b a
/// a n a n a b a r b```
/// Then we sort that matrix by its rows. The output of the transformation then is the last column and the row index in which the original string is in:
///```
/// .-.
/// a b a r b a n a n
/// a n a b a r b a n
/// a n a n a b a r b
/// a r b a n a n a b
/// b a n a n a b a r <- 4
/// b a r b a n a n a
/// n a b a r b a n a
/// n a n a b a r b a
/// r b a n a n a b a
///                '-'
///
/// Output: ("nnbbraaaa", 4)```
///
/// To handle the two kinds of output data, we will use the preloaded class BWT, whose contract is the following:
///```
/// public class BWT {
///
/// public String s;
///     public int n;
///
/// public BWT(String s, int n)
///
/// @Override public String  toString()
///     @Override public boolean equals(Object o)
///     @Override public int     hashCode()
/// }```
/// Of course we want to restore the original input, therefore you get the following hints:
///
/// 1. The output contains the last matrix column.
/// 2. The first column can be acquired by sorting the last column.
/// 3. For every row of the table: Symbols in the first column follow on symbols in the last column, in the same way they do in the input string.
/// 4. You don't need to reconstruct the whole table to get the input back.
///
/// Goal
/// The goal of this Kata is to write both, the `encode` and `decode` functions. Together they should work as the identity function on lists. (Note: For the empty input, the row number is ignored.)
///
/// Further studies
/// You may have noticed that symbols are not always consecutive, but just in proximity, after the transformation. If you're interested in how to deal with that, you should have a look at this Kata.
public class BurrowsWheeler {
    
    public static BWT encode(String s) {
        if (s == null || s.isEmpty()) {
            return new BWT(s, 0);
        }
        List<String> transformations = new ArrayList<>();
        transformations.add(s);
        String current = s;
        for (int i = 0; i < s.length() - 1; i++) {
            current = current.substring(s.length() - 1) + current.substring(0, s.length() - 1);
            transformations.add(current);
        }

        transformations.sort(String::compareTo);

        int index = transformations.indexOf(s);
        StringBuilder sb = new StringBuilder();
        transformations.forEach(transformation -> sb.append(transformation.substring(transformation.length() - 1)));

        return new BWT(sb.toString(), index);          // new BWT("stuff", -1);
    }
    
    public static String decode(String s, int n) {
        if (s == null || s.isEmpty() || n < 0) {
            return "";
        }
        char[] lastColumn = s.toCharArray();
        char[] firstColumn = lastColumn.clone();
        Arrays.sort(firstColumn);
        char currentChar = firstColumn[n];
        int currentIndex = n;

        StringBuilder result = new StringBuilder(String.valueOf(currentChar));

        for (int j = 0 ; j < lastColumn.length - 1 ; j++) {

            int counter = 0;
            for (int i = 0; i < currentIndex; i++) {
                if (firstColumn[i] == currentChar) {
                    counter++;
                }
            }
            int sCounter = 0;
            for (int i = 0; i < lastColumn.length; i++) {
                if (lastColumn[i] == currentChar) {
                    if (counter == sCounter) {
                        currentChar = firstColumn[i];
                        result.append(currentChar);
                        currentIndex = i;
                        break;
                    } else {
                        sCounter++;
                    }
                }
            }
        }
        return result.toString();
    }

    public static class BWT {

        public String s;
        public int n;

        public BWT(String s, int n) {
            this.s = s;
            this.n = n;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            BWT bwt = (BWT) o;
            return n == bwt.n && Objects.equals(s, bwt.s);
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, n);
        }

        @Override
        public String toString() {
            return "BWT{" +
                "s='" + s + '\'' +
                ", n=" + n +
                '}';
        }
    }
}