package com.lc.source.s100;

import java.math.BigInteger;
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
        double fact = factorial(rowIndex);
        for(int i=0; i<=half+1; i++) {
            ret.add((int)(Math.round(fact/(factorial(rowIndex-i)*factorial(i)))));
        }
        for(int i=half+1;i<rowIndex; i++) {
            ret.add(ret.get(rowIndex-1-i));
        }
        return ret;
    }

    public static double factorial(int a) {
        double result = 1;
        for(int j=1;j<=a;j++) {
            result = result * j;
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> b = getRow(24);
        for(Integer j:b) {
            System.out.print(" " + j);
        }
    }
}
