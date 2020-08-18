package com.lc.source.s900;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Given two positive integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.
 * Return a list of all powerful integers that have value less than or equal to bound.
 * You may return the answer in any order.  In your answer, each value should occur at most once.
 * Example 1:
 * 0 1 2 3   0 1 2
 * Input: x = 2, y = 3, bound = 10
 * Output: [2,3,4,5,7,9,10]
 * Explanation:
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 * Example 2:
 *  2,1   0 1 2  01
 * Input: x = 3, y = 5, bound = 15
 * Output: [2,4,6,8,10,14]
 * Note:
 * 1 <= x <= 100
 * 1 <= y <= 100
 * 0 <= bound <= 10^6
 */
public class S970 {
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        int a = 0, b = 0;
        List<Integer> ret = new ArrayList<>();
        if(x == 1) {
            a = 1;
        } else {
            while (Math.pow(x, a) < bound) {
                a++;
            }
        }
        if(y == 1) {
            b = 1;
        } else {
            while (Math.pow(y, b) < bound) {
                b++;
            }
        }
        for(int i=0;i<=a;i++) {
            for(int j=0;j<=b;j++) {
                int t = (int)Math.pow(x, i) + (int)Math.pow(y, j);
                if(t <= bound && !ret.contains(t)) {
                    ret.add(t);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> b = powerfulIntegers(1, 2, 100);
        for(int a:b) {
            System.out.print(" " + a);
        }
    }
}
