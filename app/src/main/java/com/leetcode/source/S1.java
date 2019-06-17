package com.leetcode.source;

public class S1 {
    public static int[] twoSum(int[] nums, int target) {
        int s=0, e=nums.length-1;
        int[] ret = new int[2];
        int[][] sour = new int[nums.length][2];
        for(int i=0;i<nums.length;i++) {
            sour[i][0] = i;
            sour[i][1] = nums[i];
        }
        quickSort(sour, s, e);
        while(sour[s][1] + sour[e][1] != target && s<e) {
            if(sour[s][1] + sour[e][1] > target) {
                e--;
            } else {
                s++;
            }
        }
        if(sour[s][0] < sour[e][0]) {
            ret[0] = sour[s][0];
            ret[1] = sour[e][0];
        } else {
            ret[0] = sour[e][0];
            ret[1] = sour[s][0];
        }
        return ret;
    }

    public static void quickSort(int[][] nums, int low, int high) {
        if(low>=high) {
            return;
        }
        int i = low;
        int j = high + 1;
        int[] tmp;
        int key = nums[i][1];
        while(i<j) {
            while (nums[++i][1] < key) {
                if(i == high) break;
            }
            while (nums[--j][1] > key) {
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
        int[] a = {-18, 12, 3, 0};

        int[] b = twoSum(a, -6);

        for(int i = 0; i < b.length; i++)
        {
            System.out.print(" " + b[i]);
        }
    }
}
