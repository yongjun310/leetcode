package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1566. Detect Pattern of Length M Repeated K or More Times
Easy

188

32

Add to List

Share
Given an array of positive integers arr,  find a pattern of length m that is repeated k or more times.

A pattern is a subarray (consecutive sub-sequence) that consists of one or more values, repeated multiple times consecutively without overlapping. A pattern is defined by its length and the number of repetitions.

Return true if there exists a pattern of length m that is repeated k or more times, otherwise return false.



Example 1:

Input: arr = [1,2,4,4,4,4], m = 1, k = 3
Output: true
Explanation: The pattern (4) of length 1 is repeated 4 consecutive times. Notice that pattern can be repeated k or more times but not less.
Example 2:

Input: arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
Output: true
Explanation: The pattern (1,2) of length 2 is repeated 2 consecutive times. Another valid pattern (2,1) is also repeated 2 times.
Example 3:

Input: arr = [1,2,1,2,1,3], m = 2, k = 3
Output: false
Explanation: The pattern (1,2) is of length 2 but is repeated only 2 times. There is no pattern of length 2 that is repeated 3 or more times.
Example 4:

Input: arr = [1,2,3,1,2], m = 2, k = 2
Output: false
Explanation: Notice that the pattern (1,2) exists twice but not consecutively, so it doesn't count.
Example 5:

Input: arr = [2,2,2,2], m = 2, k = 3
Output: false
Explanation: The only pattern of length 2 is (2,2) however it's repeated only twice. Notice that we do not count overlapping repetitions.


Constraints:

2 <= arr.length <= 100
1 <= arr[i] <= 100
1 <= m <= 100
2 <= k <= 100
Accepted
12,154
Submissions
28,928
 */

class S1566 {
    fun containsPattern(arr: IntArray, m: Int, k: Int): Boolean {
        var c = 1
        for(i in 0 until arr.size-m) {
            var t = i+m
            while(t<=arr.size-m) {
                var h = true
                for (j in 0 until m) {
                    if (arr[i + j] != arr[t + j]) {
                        if(c>=k) {
                            return true
                        }
                        h = false
                        break
                    }
                }
                if(!h) {
                    break
                }
                c++
                t += m
            }
            if(c>=k) {
                return true
            } else {
                c = 1
            }
        }
        return false
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1566().containsPattern(intArrayOf(1,2,3,1,2), 2, 2))
        }
    }

}