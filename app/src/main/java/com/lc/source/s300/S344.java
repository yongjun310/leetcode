package com.lc.source.s300;

import java.util.Stack;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class S344 {
    public static void reverseString(char[] s)  {
        int i = 0, j = s.length-1;
        char tmp;
        while(i<j) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] in = {'h', 'e', 'l', 'l', 'o'};
        reverseString(in);
        for(char a:in) {
            System.out.print(" " + a);
        }
    }
}