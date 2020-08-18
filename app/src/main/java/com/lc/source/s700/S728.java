package com.lc.source.s700;

import java.util.ArrayList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 *
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *
 * Also, a self-dividing number is not allowed to contain the digit zero.
 *
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 *
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 *
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class S728 {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        for(int i = left; i<=right; i++) {
            if(isSelfDivided(i)) {
                ret.add(i);
            }
        }
        return ret;
    }

    static boolean isSelfDivided(int n) {
        int tmp = n;
        while(tmp > 0) {
            int t = tmp%10;
            if(t == 0 || n%t != 0) {
                return false;
            }
            tmp = tmp/10;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> b = selfDividingNumbers(1, 225);
        for(int a:b) {
            System.out.print(" " + a);
        }
    }
}
