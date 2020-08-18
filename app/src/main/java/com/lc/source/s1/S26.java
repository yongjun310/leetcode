package com.lc.source.s1;

public class S26 {
    public static int removeDuplicates(int[] nums) {
        int len = 1;
        if(nums.length == 0) {
            return 0;
        }
        int tmp = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(tmp == nums[i]) {
                continue;
            }
            nums[len++] = nums[i];
            tmp = nums[i];
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 0};

        int b = removeDuplicates(a);

        System.out.print(" " + b);
    }
}
