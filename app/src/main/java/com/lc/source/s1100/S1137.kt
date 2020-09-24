package com.lc.source.s1100

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1137. N-th Tribonacci Number
Easy

361

43

Add to List

Share
The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.



Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537


Constraints:

0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
Accepted
49,717
Submissions
89,164
 */

class S1137 {
    fun tribonacci(n: Int): Int {
        var n1 = 0
        var n2 = 1
        var n3 = 1
        if(n==0) {
            return 0
        } else if(n==1) {
            return 1
        } else if(n==2) {
            return 1
        }
        var cur = n - 2
        while(cur-->0) {
            var t = n3
            n3 = n1+n2+n3
            n1 = n2
            n2 = t
        }
        return n3
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1137().tribonacci(25))
        }
    }

}