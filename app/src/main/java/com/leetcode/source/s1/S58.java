package com.leetcode.source.s1;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
public class S58 {
    public static int lengthOfLastWord(String s)  {
        s = s.trim();
        if(s.length() == 0) {
            return 0;
        }
        int i=s.length()-1;
        while(i>=0 && s.charAt(i--) != ' ');
        return i>=0?s.length()-1-i-1:s.length()-1-i;
    }

    public static void main(String[] args) {
        int b = lengthOfLastWord(" ");

        System.out.print(" " + b);
    }
}
