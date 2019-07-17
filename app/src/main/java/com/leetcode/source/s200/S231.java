package com.leetcode.source.s200;
/*
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false
 */
public class S231 {
    public static  boolean isPowerOfTwo(int n) {
        if(n<=0) {
            return false;
        }
        return (n&(n-1)) == 0;
    }

    public static void main(String[] args) {
        boolean b = isPowerOfTwo(1);
        System.out.print(" " + b);
    }
}
