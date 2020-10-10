package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1550. Three Consecutive Odds
Easy

121

20

Add to List

Share
Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.


Example 1:

Input: arr = [2,6,4,1]
Output: false
Explanation: There are no three consecutive odds.
Example 2:

Input: arr = [1,2,34,3,4,5,7,23,12]
Output: true
Explanation: [5,7,23] are three consecutive odds.


Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
Accepted
20,988
Submissions
31,578
 */

class S1550 {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        for(i in 2 until arr.size) {
            if(arr[i] and 1 == 1 && arr[i-1] and 1 == 1 && arr[i-2] and 1 == 1) {
                return true
            }
        }
        return false
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}