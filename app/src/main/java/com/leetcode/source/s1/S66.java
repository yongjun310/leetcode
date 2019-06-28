package com.leetcode.source.s1;

public class S66 {
    public static int[] plusOne(int[] digits) {
        int plus;
        for(int i=0; i<digits.length; i++) {
            plus = digits[digits.length-1-i] + 1;
            if(plus != 10) {
                digits[digits.length-1-i] = plus;
                return digits;
            } else {
                digits[digits.length-1-i] = 0;
            }
        }
        int a[] = new int[digits.length + 1];
        a[0] = 1;
        return a;
    }

    public static void main(String[] args) {
        int[] a = {9, 9, 9, 9};

        int[] b = plusOne(a);

        for(int i=0; i<b.length; i++) {
            System.out.print(" " + b[i]);
        }

    }
}
