package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1502. Can Make Arithmetic Progression From Sequence
Easy

194

13

Add to List

Share
Given an array of numbers arr. A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

Return true if the array can be rearranged to form an arithmetic progression, otherwise, return false.



Example 1:

Input: arr = [3,5,1]
Output: true
Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
Example 2:

Input: arr = [1,2,4]
Output: false
Explanation: There is no way to reorder the elements to obtain an arithmetic progression.


Constraints:

2 <= arr.length <= 1000
-10^6 <= arr[i] <= 10^6
Accepted
28,701
Submissions
39,894
 */

class S1502 {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        arr.sort()
        var diff = arr[1] - arr[0]
        for(i in 2 until arr.size) {
            if(arr[i] - arr[i-1] != diff) {
                return false
            }
        }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}