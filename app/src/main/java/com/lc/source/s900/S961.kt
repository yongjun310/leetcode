package com.lc.source.s900

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
961. N-Repeated Element in Size 2N Array
Easy

485

235

Add to List

Share
In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.



Example 1:

Input: [1,2,3,3]
Output: 3
Example 2:

Input: [2,1,2,5,3,2]
Output: 2
Example 3:

Input: [5,1,5,2,5,3,5,4]
Output: 5


Note:

4 <= A.length <= 10000
0 <= A[i] < 10000
A.length is even
Accepted
121,994
Submissions
165,100
 */

class S961 {
    fun repeatedNTimes(A: IntArray): Int {
        var set = HashSet<Int>()
        for(i in 0..A.size) {
            if(set.contains(A[i])) {
                return A[i]
            } else {
                set.add(A[i])
            }
        }
        return -1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}