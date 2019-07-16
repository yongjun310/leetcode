package com.leetcode.source.s400;
/*
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.   n*(n-1)/2 = t  n2 - n -2t=0
 */
public class S441 {
    public static int arrangeCoins(int n) {
        return (int)(1+Math.sqrt(1+(long)8*n))/2-1;
    }

    public static void main(String[] args) {
        int b = arrangeCoins(1804289383);
        System.out.print(" " + b);
    }
}
