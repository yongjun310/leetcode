package com.lc.source.s100;

public class S121 {
    public static int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length <= 1) {
            return 0;
        }
        int min = prices[0];

        for(int i=1; i<prices.length; i++) {
            if(prices[i] - min > max) {
                max = prices[i] - min;
            }
            if(min > prices[i]) {
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test = {7,1,5,3,6,4};
        int b = maxProfit(test);
        System.out.print(" " + b);
    }
}
