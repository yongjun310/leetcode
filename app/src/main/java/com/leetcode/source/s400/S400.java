package com.leetcode.source.s400;
/*
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation: (9-1+1)*1 + (99-10+1)*2 + (999100+1)*3  9 + 180 + 2700
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ... is a 0, which is part of the number 10.
 */
public class S400 {
    public static int findNthDigit(int n) {
        int t = 0;
        while(true) {
            if(n>Math.pow(10, t)*9*(t+1)) {
                n -= Math.pow(10, t)*9*(t+1);
            } else {
                break;
            }
            t++;
        }
        int a = n/(t+1);
        int b = n%(t+1);
        int s = (int)Math.pow(10, t) + a - (b==0?1:0);
        if(b == 0) {
            b = t+1;
        }
        int i = t+1 - b;
        while(--i>=0) {
            s /= 10;
        }
        return s%10;
    }

    public static void main(String[] args) {
        int b = findNthDigit(19);
        System.out.print(" " + b);
    }
}
