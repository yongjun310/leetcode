package com.leetcode.source.s1;

public class S53 {
    public static int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int sum = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++) {
            sum = sum + nums[i] > nums[i]? sum+nums[i]:nums[i];
            if(max < sum) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};

        int b = maxSubArray(a);

        System.out.print(" " + b);
    }
}
