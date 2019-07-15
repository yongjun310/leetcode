package com.leetcode.source.s1;

public class S9 {
    public static boolean isPalindrome(int x) {
        int in = x;
        if(x<0) {
            return false;
        }
        if(x<=9) {
            return true;
        }
        int re = 0;
        while(true) {
            if(x/10>0) {
                re = re*10 + x%10;
                x = x/10;
            } else {
                re = re*10 + x;
                break;
            }
        }
        return in == re;
    }


    public static void main(String[] args) {
        boolean b = isPalindrome(1221);

        System.out.print(" " + b);
    }
}
