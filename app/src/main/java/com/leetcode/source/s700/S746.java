package com.leetcode.source.s600;

public class S746 {
    public static minCostClimbingStairs(int[] cost) {
        return costCompute(cost, 0);
    }

    public int costCompute(int[] cost, int start) {
        if(start == cost.length-1) {
            return 0;
        }
        if(start == cost.length-2) {
            return cost[cost.length-2];
        }
        if(start == cost.length-3) {
            return Math.min(cost[cost.length-3] + cost[cost.length-1], cost[cost.length-3] + cost[cost.length -2]);
        }
        return Math.min(costCompute(cost, start+3) + cost[start] + cost[start+2],
                costCompute(cost, start+2) + cost[start] + cost[start+1]);
    }


    public static void main(String[] args) {
        int[] test = {-1, -2, -3, -4, 60};
        int b = maximumProduct(test);
        System.out.print(" " + b);
    }
}
