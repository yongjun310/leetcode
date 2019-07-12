package com.leetcode.source.s1000;

/*Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.



Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]


Note:

1 <= arr.length <= 10000
0 <= arr[i] <= 9*/
public class S1089 {
    public static void duplicateZeros(int[] arr) {
        int zc = 0;
        boolean sing = false;
        for(int i=0; i<arr.length-zc; i++) {
            if(i == arr.length-1-zc) {
                sing = true;
            } else if(arr[i] == 0) {
                zc++;
            }
        }
        for(int i=arr.length-1-zc;i>=0;i--) {
            if(sing) {
                arr[i+zc] = arr[i];
                sing = false;
                continue;
            }
            if(arr[i] == 0) {
               arr[i+zc] = 0;
               zc--;
            }
            arr[i+zc] = arr[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {8,4,5,0,0,0,0,7};

        duplicateZeros(a);
        for(int i=0; i<a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }
}
