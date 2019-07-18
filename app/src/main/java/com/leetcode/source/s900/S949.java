package com.leetcode.source.s900;

/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00,
 * a time is larger if more time has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 * Example 1:
 *
 * Input: [1,2,3,4]
 * Output: "23:41"
 * Example 2:
 *
 * Input: [5,5,5,5]
 * Output: ""
 *
 * Note:
 * A.length == 4
 * 0 <= A[i] <= 9
 */
public class S949 {
    public static String largestTimeFromDigits(int[] A) {
        int count6 = 0;
        for(int i:A) {
            if(i>=6) {
                count6++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (i == 0 && (A[j] <= 2 && count6<2 || A[j] <=1) && (A[i] > 2 || A[i] < A[j] && count6<=1 || count6>=2 && (A[i]>=2 || A[i]<A[j])) ||
                        i == 1 && (((A[0] == 2 && (A[i] > 3 || A[i] < A[j]) && A[j] <= 3) || A[0] < 2 && A[i] < A[j])) ||
                        i == 2 && A[j] <= 5 && (A[i] > 5 || A[i] < A[j])) {
                    int tmp = A[j];
                    A[j] = A[i];
                    A[i] = tmp;
                }
            }
        }
        if(A[0]>2 || A[0] == 2&&A[1]>3 || A[2]>5) {
            return "";
        }

        return "" + A[0] + A[1] + ":" + A[2] + A[3];
    }


    public static void main(String[] args) {
        int[] a = {1,9,6,0};
        String b = largestTimeFromDigits(a);
        System.out.print(" " + b);
    }
}
