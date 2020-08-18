package com.lc.source.s400;

import java.util.regex.Pattern;

/**
 * Given a non-empty string check if it can be constructed by taking a
 * substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"  a b ab ab a b
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba" a baab a
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class S459 {
    public static boolean repeatedSubstringPattern(String s)  {
        if(s==null || s.length() == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(s);
        sb = sb.delete(0,1);
        String ss = sb.substring(0, sb.length()-1);
        return ss.contains(s);
    }

    public static void main(String[] args) {

        boolean b = repeatedSubstringPattern("abaab");

        System.out.print(" " + b);
    }
}
