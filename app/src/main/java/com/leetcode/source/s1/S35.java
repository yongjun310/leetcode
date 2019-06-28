package com.leetcode.source.s1;

public class S35 {
    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        int tmp = nums[0];
        if(target <= tmp) {
            return 0;
        }
        for(int i=1; i<nums.length; i++) {
            if(tmp <= target && nums[i] >= target) {
                return i;
            }
            tmp = nums[i];
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};

        int b = searchInsert(a, 5);

        System.out.print(" " + b);
    }
}
