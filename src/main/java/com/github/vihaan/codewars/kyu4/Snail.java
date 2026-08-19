package com.github.vihaan.codewars.kyu4;

import java.util.ArrayList;
import java.util.List;

/// Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.
/// ```array = [[1,2,3],
///          [4,5,6],
///          [7,8,9]]```
/// ```snail(array) #=> [1,2,3,6,9,8,7,4,5]```
/// For better understanding, please follow the numbers of the next array consecutively:
/// ```array = [[1,2,3],
///          [8,9,4],
///          [7,6,5]]```
/// ```snail(array) #=> [1,2,3,4,5,6,7,8,9]```
/// NOTE: The idea is not sort the elements from the lowest value to the highest; the idea is to traverse the 2-d array in a clockwise snailshell pattern.
///
/// NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].
public class Snail {

    public static int[] snail(int[][] array) {

        if (array.length == 1 && array[0].length == 0) {
            return new int[1];
        }
        int leftTop = 0;
        int leftBottom = array.length - 1;
        int rightTop = 0;
        int rightBottom = array.length - 1;

        List<Integer> result = new ArrayList<>();
        do {
            //top row
            int tempLeftTop = leftTop;
            while (tempLeftTop <= rightBottom) {
                result.add(array[leftTop][tempLeftTop]);
                tempLeftTop++;
            }
            rightTop += 1;

            // right border column
            int tempRightTop = rightTop;
            while (tempRightTop <= rightBottom) {
                result.add(array[tempRightTop][rightBottom]);
                tempRightTop++;
            }
            rightBottom -= 1;

            //bottom row
            int tempRightBottom = rightBottom;
            while (tempRightBottom >= leftTop) {
                result.add(array[leftBottom][tempRightBottom]);
                tempRightBottom--;
            }
            leftBottom -= 1;

            // left border column
            int tempVerticalEnd = leftBottom;
            while (tempVerticalEnd >= rightTop) {
                result.add(array[tempVerticalEnd][leftTop]);
                tempVerticalEnd--;
            }
            leftTop += 1;

            if (leftTop == rightTop && rightTop == rightBottom && leftBottom == rightBottom) {
                result.add(array[leftTop][rightTop]);
                break;
            }

        } while (leftTop < leftBottom && rightTop < rightBottom);
        return result.stream().mapToInt(Integer::intValue).toArray();
   } 
}