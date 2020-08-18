package com.lc.source.s500;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "lc".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 *
 * Example 1:
 *
 * Input: "USA"
 * Output: True
 *
 *
 * Example 2:
 *
 * Input: "FlaG"
 * Output: False
 *
 *
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class S520 {
    public static boolean detectCapitalUse(String word)  {
        char f = word.charAt(0);
        char c = 0;
        for(int i=1;i<word.length();i++) {
            if(i==1) {
                c = word.charAt(i);
                if(f >= 'a' && f <= 'z' && c >= 'A' && c <= 'Z') {
                    return false;
                }
            } else if(!isSameCap(word.charAt(i), c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSameCap(char a, char b) {
        return a >= 'A' && a <= 'Z' && b >= 'A' && b <= 'Z' ||
                a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z';
    }

    public static void main(String[] args) {

        boolean b = detectCapitalUse("Frr");

        System.out.print(" " + b);
    }
}
