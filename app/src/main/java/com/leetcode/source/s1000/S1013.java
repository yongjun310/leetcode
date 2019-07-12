package com.leetcode.source.s1000;

/*Given an array A of integers, return true if and only if we can partition the array
 into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i]
 == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])



Example 1:

Input: [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
Example 2:

Input: [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false
Example 3:

Input: [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4


Note:

3 <= A.length <= 50000
-10000 <= A[i] <= 10000*/
public class S1013 {
    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i=0;i<A.length; i++) {
            sum += A[i];
        }
        if(sum%3 != 0) {
            return false;
        }
        int subSum = sum/3;
        int count = 0;
        sum = 0;
        for(int i=0;i<A.length; i++) {
            sum += A[i];
            if(sum == subSum) {
                count++;
                sum = 0;
            }
        }
        if(subSum == 0 && count>=3) {
            return true;
        }
        if(count == 3) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {0,2,1,-6,6,7,9,-1,2,0,1};

        boolean b = canThreePartsEqualSum(a);

        System.out.print(" " + b);
    }
}
