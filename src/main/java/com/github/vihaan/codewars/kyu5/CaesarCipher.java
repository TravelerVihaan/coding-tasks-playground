package com.github.vihaan.codewars.kyu5;

import java.util.ArrayList;
import java.util.List;

/**
 * The action of a Caesar cipher is to replace each plaintext letter (plaintext letters are from 'a' to 'z' or from 'A' to 'Z')
 * with a different one a fixed number of places up or down the alphabet.
 *
 * This program performs a variation of the Caesar shift. The shift increases by 1 for each character (on each iteration).
 *
 * If the shift is initially 1, the first character of the message to be encoded will be shifted by 1,
 * the second character will be shifted by 2, etc...
 * Coding: Parameters and return of function "movingShift"
 *
 * param s: a string to be coded
 *
 * param shift: an integer giving the initial shift
 *
 * The function "movingShift" first codes the entire string and then returns an array of strings containing
 * the coded string in 5 parts (five parts because, to avoid more risks, the coded message will be given to five runners,
 * one piece for each runner).
 *
 * If possible the message will be equally divided by message length between the five runners.
 * If this is not possible, parts 1 to 5 will have subsequently non-increasing lengths,
 * such that parts 1 to 4 are at least as long as when evenly divided, but at most 1 longer.
 * If the last part is the empty string this empty string must be shown in the resulting array.
 *
 * For example, if the coded message has a length of 17 the five parts will have lengths of 4, 4, 4, 4, 1.
 * The parts 1, 2, 3, 4 are evenly split and the last part of length 1 is shorter.
 * If the length is 16 the parts will be of lengths 4, 4, 4, 4, 0. Parts 1, 2, 3, 4 are evenly split
 * and the fifth runner will stay at home since his part is the empty string. If the length is 11,
 * equal parts would be of length 2.2, hence parts will be of lengths 3, 3, 3, 2, 0.
 *
 * You will also implement a "demovingShift" function with two parameters
 * Decoding: parameters and return of function "demovingShift"
 *
 *     an array of strings: s (possibly resulting from "movingShift", with 5 strings)
 *
 *     an int shift
 *
 * "demovingShift" returns a string.
 * Example:
 *
 * u = "I should have known that you would have a perfect answer for me!!!"
 *
 * movingShift(u, 1) returns :
 *
 * v = ["J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!"]
 *
 * (quotes added in order to see the strings and the spaces, your program won't write these quotes, see Example Test Cases)
 *
 * and demovingShift(v, 1) returns u. #Ref:
 *
 * Caesar Cipher : http://en.wikipedia.org/wiki/Caesar_cipher
 */
public class CaesarCipher {
	public static List<String> movingShift(String s, int shift) {
		int n = s.length();
		StringBuilder coded = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			int amt = shift + i;
			if (Character.isUpperCase(c)) {
				coded.append((char) ('A' + Math.floorMod(c - 'A' + amt, 26)));
			} else if (Character.isLowerCase(c)) {
				coded.append((char) ('a' + Math.floorMod(c - 'a' + amt, 26)));
			} else {
				coded.append(c);
			}
		}
		return splitParts(coded.toString());
	}

	public static String demovingShift(List<String> s, int shift) {
		StringBuilder coded = new StringBuilder();
		for (String part : s) {
			coded.append(part);
		}
		int n = coded.length();
		StringBuilder result = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			char c = coded.charAt(i);
			int amt = shift + i;
			if (Character.isUpperCase(c)) {
				result.append((char) ('A' + Math.floorMod(c - 'A' - amt, 26)));
			} else if (Character.isLowerCase(c)) {
				result.append((char) ('a' + Math.floorMod(c - 'a' - amt, 26)));
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}

	private static List<String> splitParts(String coded) {
		int n = coded.length();
		int p = (n + 4) / 5;
		int[] sizes = new int[] { p, p, p, p, 0 };
		int excess = 4 * p - n;
		int idx = 3;
		while (excess > 0 && idx >= 0) {
			sizes[idx]--;
			excess--;
			idx--;
		}
		sizes[4] = n - (sizes[0] + sizes[1] + sizes[2] + sizes[3]);
		List<String> parts = new ArrayList<>();
		int pos = 0;
		for (int size : sizes) {
			parts.add(coded.substring(pos, pos + size));
			pos += size;
		}
		return parts;
	}

}