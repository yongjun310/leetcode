package com.leetcode.source.s800;

/**
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters
 * in A so that the result equals B.
 *
 *
 *
 * Example 1:
 *
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 *
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 *
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 *
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 *
 * Input: A = "", B = "aa"
 * Output: false
 *
 *
 * Note:
 *
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 */
public class S859 {
    public static boolean buddyStrings(String A, String B) {
        if(A == null || B == null || A.length() < 2 || A.length() != B.length()) {
            return false;
        }
        Character d = null,e = null;
        int[] cc = new int[26];
        int count = 0;
        for(int i=0;i<A.length();i++) {
            cc[A.charAt(i)-'a']++;
            if(A.charAt(i) != B.charAt(i)) {
                if(d == null) {
                    d = A.charAt(i);
                    e = B.charAt(i);
                } else {
                    if(count == 1 || d != B.charAt(i) || e != A.charAt(i)) {
                        return false;
                    } else {
                        count = 1;
                    }
                }
            }
        }
        if(count == 0) {
            for(int a:cc) {
                if(a>1) {
                    return true;
                }
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {

        boolean b = buddyStrings("ab", "ab");

        System.out.print(" " + b);
    }
}
