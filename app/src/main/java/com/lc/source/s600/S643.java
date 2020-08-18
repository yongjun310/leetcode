package com.lc.source.s600;

public class S643 {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0, tmp, lastSum;
        for(int i=0; i<k; i++) {
            sum += nums[i];
        }
        lastSum = sum;
        for(int i=k; i<nums.length; i++) {
            tmp = lastSum - nums[i-k] + nums[i];
            if(tmp>sum) {
                sum = tmp;
            }
            lastSum = tmp;
        }
        return (double)sum/k;
    }


    public static void main(String[] args) {
        int[] test = {7,4,5,8,8,3,9,8,7,6};
        double b = findMaxAverage(test, 7);
        System.out.print(" " + b);
    }
}
