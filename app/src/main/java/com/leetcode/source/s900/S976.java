package com.leetcode.source.s900;

import java.util.Arrays;

/**
 * Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.
 *
 * If it is impossible to form any triangle of non-zero area, return 0.
 * Example 1:
 *
 * Input: [2,1,2]
 * Output: 5
 * Example 2:
 *
 * Input: [1,2,1]
 * Output: 0
 * Example 3:
 *
 * Input: [3,2,3,4]
 * Output: 10
 * Example 4:
 *
 * Input: [3,6,2,3]
 * Output: 8
 *
 *
 * Note:
 *
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 */
public class S976 {
    public static int largestPerimeter(int[] A) {
        int a=0, b=0, c=0, sum = 0;
        Arrays.sort(A);
        for(int i=A.length-1; i>=0; i--) {
            if(A[i] > c) {
                a = b;
                b = c;
                c = A[i];
            } else if(A[i] > b) {
                a = b;
                b = A[i];
            } else if(A[i] > a) {
                a = A[i];
            }
            if(a != 0 && b != 0 && a+b<=c){
                c = b;
                b = a;
                a = 0;
            } else if(a+b>c && sum<a+b+c) {
                sum = a+b+c;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1,4,18,3,8,4,4};
        int b = largestPerimeter(a);
        System.out.print(" " + b);
    }
}
