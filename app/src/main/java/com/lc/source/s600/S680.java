package com.lc.source.s600;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class S680 {
    public static boolean validPalindrome(String s) {
        int count = 0;
        int i = 0, j = s.length()-1;
        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) {
                if(count == 0){
                    count++;
                } else {
                    return false;
                }
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            } else {
                i++;
                j--;
            }

        }
        return true;
    }

    public static boolean isPalindrome(String s, int a, int e) {
        while(a<e) {
            if(s.charAt(a) == s.charAt(e)) {
                a++;
                e--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        boolean b = validPalindrome("ececabbacec");

        System.out.print(" " + b);
    }
}
