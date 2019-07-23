package com.leetcode.source.s400;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class S415 {
    public static String addStrings(String num1, String num2)  {
        int l1 = num1.length()-1;
        int l2 = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        boolean enter = false;
        while(l1>=0&& l2>=0) {
            char c = (char)(num1.charAt(l1) + num2.charAt(l2) - '0' + (enter?1:0));
            if(c>'9') {
                enter = true;
                c = (char)(c - 10);
            } else {
                enter = false;
            }
            l1--;
            l2--;
            sb.insert(0,c);
            if(l1<0) {
                while(l2>=0) {
                    c = (char) (num2.charAt(l2) + (enter ? 1 : 0));
                    if (c > '9') {
                        enter = true;
                        c = (char) (c - 10);
                    } else {
                        enter = false;
                    }
                    l2--;
                    sb.insert(0,c);
                }
            }
            if(l2<0) {
                while(l1>=0) {
                    c = (char) (num1.charAt(l1) + (enter ? 1 : 0));
                    if (c > '9') {
                        enter = true;
                        c = (char) (c - 10);
                    } else {
                        enter = false;
                    }
                    l1--;
                    sb.insert(0,c);
                }
            }
        }
        if(enter) {
            sb.insert(0,'1');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String b = addStrings("1914", "9321");

        System.out.print(" " + b);
    }
}
