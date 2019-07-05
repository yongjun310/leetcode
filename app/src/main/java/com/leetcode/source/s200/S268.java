package com.leetcode.source.s200;

public class S268 {
    public static int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length+1)/2;
        for(int i=0; i<nums.length; i++) {
            sum = sum - nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = {9,6,4,2,3,5,7,0,1};
        int b = missingNumber(test);
        System.out.print(" " + b);
    }
}
