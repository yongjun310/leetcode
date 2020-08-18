package com.lc.source.s1;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class S28 {
    public static int strStr(String haystack, String needle) {
        int[] t = new int[needle.length()];
        if(needle.length() == 0) {
            return 0;
        }
        t[0] = -1;
        for(int i=1;i<needle.length();i++) {
            t[i] = getRetryIndex(needle.substring(0, i));
        }
        int i=0,j=0;
        while(i<haystack.length() && j<needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
                if(j == needle.length()) {
                    return i-j;
                }
            } else {
                i += t[j]>0?t[j]-j+1:1-j;
                j = t[j]>0?t[j]:0;
            }
        }
        return -1;
    }

    public static int getRetryIndex(String s) {
        int len = s.length();
        while(len-->0) {
            String sb = s.substring(0, len);
            if(s.endsWith(sb)) {
                return len;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int b = strStr("mississippi", "issip");

        System.out.print(" " + b);
    }
}
