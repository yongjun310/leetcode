package com.leetcode.source.s600;

public class S628 {
    public static int maximumProduct(int[] nums) {
        int mx1 = Integer.MIN_VALUE;
        int mx2 = Integer.MIN_VALUE;
        int mx3 = Integer.MIN_VALUE;
        int mn1 = Integer.MAX_VALUE;
        int mn2 = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > mx1) {
                mx3 = mx2;
                mx2 = mx1;
                mx1 = nums[i];
            } else if(nums[i] > mx2) {
                mx3 = mx2;
                mx2 = nums[i];
            } else if(nums[i] > mx3) {
                mx3 = nums[i];
            }
            if(nums[i] < mn1) {
                mn2 = mn1;
                mn1 = nums[i];
            } else if(nums[i] < mn2) {
                mn2 = nums[i];
            }
        }
        int ret = Integer.MIN_VALUE;
        int mul = mx1 * mx2 * mx3;
        int ss = mn1 * mn2* mx1;
        if(mul > ret) {
            ret = mul;
        }
        if(ss > ret && mn2 != Integer.MAX_VALUE) {
            ret = ss;
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] test = {-1, -2, -3, -4, 60};
        int b = maximumProduct(test);
        System.out.print(" " + b);
    }
}
