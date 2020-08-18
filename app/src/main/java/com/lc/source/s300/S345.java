package com.lc.source.s300;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "lc"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 */
public class S345 {
    public static String reverseVowels(String s)  {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length()-1;
        char tmp;
        while(i<j) {
            while(i<j&&!isVowels(chars[i])) {
                i++;
            }
            while(i<j&&!isVowels(chars[j])) {
                j--;
            }
            if(i>=j){
                break;
            }
            tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static boolean isVowels(char c) {
        String ow = "aeiouAEIOU";
        return ow.contains(c+"");
    }

    public static void main(String[] args) {
        String b = reverseVowels("OE");

        System.out.print(" " + b);
    }
}
