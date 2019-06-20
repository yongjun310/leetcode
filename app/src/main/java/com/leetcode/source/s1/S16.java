package com.leetcode.source.s1;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that
 * the sum is closest to target. Return the sum of the three integers. You may assume that each
 * input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class S16 {
    public static int threeSumClosest(int[] nums, int target) {
        quickSort(nums, 0, nums.length-1);
        int closest = target - nums[0] - nums[1] - nums[2];
        for(int i=0; i<nums.length-1; i++) {
            int l = i+1;
            int h = nums.length-1;
            int newTarget = target - nums[i];
            while(l<h) {
                int tmp = newTarget - nums[l] - nums[h];
                if(tmp == 0) {
                    return target;
                }
                if(Math.abs(tmp) < Math.abs(closest)) {
                    closest = tmp;
                }
                if(newTarget>nums[l]+nums[h]) {
                    l++;
                } else {
                    h--;
                }
            }
        }
        return target - closest;
    }

    public static void quickSort(int[] nums, int low, int high) {
        if(low>=high) {
            return;
        }
        int i = low;
        int j = high + 1;
        int tmp;
        int key = nums[i];
        while(i<j) {
            while (nums[++i] < key) {
                if(i == high) break;
            }
            while (nums[--j] > key) {
                if(j == low) break;
            }
            if(i>=j) {
                break;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        tmp = nums[low];
        nums[low] = nums[j];
        nums[j] = tmp;
        quickSort(nums, low, j-1);
        quickSort(nums, j+1, high);
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 0};

        int b = threeSumClosest(a, 100);

        System.out.print(" " + b);
    }
}
