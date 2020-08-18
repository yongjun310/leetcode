package com.lc.source.s500;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while
 * still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take lc contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class S557 {
    public static String reverseWords(String s) {
        s = s.trim();
        if(s.length() < 2) {
            return s;
        }
        char[] cs = s.toCharArray();
        int i = 0;
        int a = 0;
        int e = 0;
        char tmp;
        while(true) {
            if(cs[++i] == ' ' || i == s.length()-1) {
                if(i != s.length()-1) {
                    e = i - 1;
                } else {
                    e = s.length()-1;
                }
                while(a<e) {
                    tmp = cs[a];
                    cs[a] = cs[e];
                    cs[e] = tmp;
                    a++;
                    e--;
                }
                if(i == s.length()-1) {
                    break;
                }
                a = i+1;
            }
        }
        return new String(cs);
    }

    public static void main(String[] args) {

        String b = reverseWords("Let's take lc contest");

        System.out.print(" " + b);
    }
}
