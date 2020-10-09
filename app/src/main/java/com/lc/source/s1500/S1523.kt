package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1523. Count Odd Numbers in an Interval Range
Easy

126

13

Add to List

Share
Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).



Example 1:

Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].
Example 2:

Input: low = 8, high = 10
Output: 1
Explanation: The odd numbers between 8 and 10 are [9].


Constraints:

0 <= low <= high <= 10^9
Accepted
14,881
Submissions
26,752
 */

class S1523 {
    fun countOdds(low: Int, high: Int): Int {
        var c = 0
        if(low%2 != 0) {
            c++
        }
        if(high%2 != 0) {
            c++
        }
        c += (high-low - if(c==2) {2} else {0})/2
        return c
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}