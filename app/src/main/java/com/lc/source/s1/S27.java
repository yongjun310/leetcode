package com.lc.source.s1;

public class S27 {
    public static int removeElement(int[] nums, int val) {
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 2, 3};

        int b = removeElement(a, 2);

        System.out.print(" " + b);
    }
}
