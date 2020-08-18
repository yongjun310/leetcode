package com.lc.source.s300;

import java.util.Arrays;

/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
 */
public class S367 {
    public static boolean isPerfectSquare(int num) {
        if(num < 1) return false;
        if(num == 1) return true;
        long left = 0, right = num/2;
        while(left <= right)
        {
            long mid = (left+right)/2;
            long val = mid*mid;
            if(val == num) return true;
            else if(val > num) right = mid-1;
            else left = mid+1;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = isPerfectSquare(16);
        System.out.print(" " + b);
    }
}
