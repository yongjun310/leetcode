package com.lc.source.s600;

public class S665 {
    public static boolean checkPossibility(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        int preCur = nums[0];
        int cur = nums[0];
        int count = 0;
        for(int i=1; i<nums.length; i++) {
            if(cur>nums[i]) {
                if(preCur<nums[i]) {
                    cur = nums[i];
                }
                count++;
                if(count > 1) {
                    return false;
                }
                if(i == 1) {
                    cur = nums[i];
                }
            } else {
                preCur = nums[i-1];
                cur = nums[i];
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] test = {1,2,5,4,3};
        boolean b = checkPossibility(test);
        System.out.print(" " + b);
    }
}
