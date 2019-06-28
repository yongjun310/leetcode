package com.leetcode.source.s100;

import java.util.ArrayList;
import java.util.List;

public class S119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        if (rowIndex == 0) {
            ret.add(1);
            return  ret;
        }
        int half = (rowIndex-1)/2;
        for(int i=0; i<=half+1; i++) {
            ret.add(factorial(rowIndex)/(factorial(rowIndex-i)*factorial(i)));
        }
        for(int i=half+1;i<rowIndex; i++) {
            ret.add(ret.get(rowIndex-1-i));
        }
        return ret;
    }

    public static int factorial(int a) {
        int result = 1;
        for(int j=1;j<=a;j++) {
            result = result * j;
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> b = getRow(0);
        for(Integer j:b) {
            System.out.print(" " + j);
        }
    }
}
