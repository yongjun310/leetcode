package com.leetcode.source.s300;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class S387 {
    public static int firstUniqChar(String s)  {
        int[] c = new int[26];
        for(int i=0;i<s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<s.length();i++) {
            if(c[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int b = firstUniqChar("loveleetcode");

        System.out.print(" " + b);
    }
}
