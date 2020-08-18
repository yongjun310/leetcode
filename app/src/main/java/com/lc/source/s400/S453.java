package com.lc.source.s400;

import java.util.Arrays;
import java.util.Iterator;

/*
Given a non-empty integer array of size n, find the minimum number of moves
 required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class S453 {
    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        long sum = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
            sum += nums[i];
        }
        return (int)(sum-nums.length*min);
    }

    public static void main(String[] args) {
        int[] a = {5,6,8,8,5};
        int b = minMoves(a);
        System.out.print(" " + b);
    }
}
