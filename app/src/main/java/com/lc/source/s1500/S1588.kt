package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1588. Sum of All Odd Length Subarrays
Easy

193

24

Add to List

Share
Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.

A subarray is a contiguous subsequence of the array.

Return the sum of all odd-length subarrays of arr.



Example 1:

Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
Example 2:

Input: arr = [1,2]
Output: 3
Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
Example 3:

Input: arr = [10,11,12]
Output: 66


Constraints:

1 <= arr.length <= 100
1 <= arr[i] <= 1000
Accepted
12,410
Submissions
15,261
 */

class S1588 {
    fun sumOddLengthSubarrays(arr: IntArray): Int {
        var l = arr.size
        var i = 1
        var sum = 0
        while(i<=l) {
            for(j in 0..l-i) {
                for(k in 0 until i) {
                    sum += arr[j+k]
                }
            }
            i += 2
        }
        return sum
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}