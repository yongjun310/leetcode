package com.leetcode.source.s100;

public class S169 {
    public static int majorityElement(int[] prices) {
        int count = 0;
        int elem = 0;
        for(int i=0; i<prices.length; i++) {
            if(count == 0) {
                elem = prices[i];
                count++;
            } else {
                if(elem == prices[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return elem;
    }

    public static void main(String[] args) {
        int[] test = {8,8,7,7,7};
        int b = majorityElement(test);
        System.out.print(" " + b);
    }
}
