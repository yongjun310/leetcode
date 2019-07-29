package com.leetcode.source.s700;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 *
 *
 * Example 1:
 *
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 *
 * Input: "here"
 * Output: "here"
 * Example 3:
 *
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class S709 {
    public static String toLowerCase(String str) {
        if(str == null || str == "") {
            return str;
        }
        char[] cs = str.toCharArray();
        for(int i=0;i<cs.length;i++) {
            if(cs[i] >= 'A' && cs[i] <= 'Z') {
                cs[i] += 32;
            }
        }
        return new String(cs);
    }

    public static void main(String[] args) {

        String b = toLowerCase("heRe");

        System.out.print(" " + b);
    }
}
