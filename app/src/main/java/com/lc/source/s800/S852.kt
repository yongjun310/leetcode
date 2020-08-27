package com.lc.source.s800

import java.lang.StringBuilder
import java.util.*

/*
852. Peak Index in a Mountain Array
Easy

722

1219

Add to List

Share
Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

Example 1:

Input: [0,1,0]
Output: 1
Example 2:

Input: [0,2,1,0]
Output: 1
Note:

3 <= A.length <= 10000
0 <= A[i] <= 10^6
A is a mountain, as defined above.
 */

class S852 {
    fun peakIndexInMountainArray(A: IntArray): Int {
        for(i in 1..A.size-1) {
            if(A[i]<A[i-1]) {
                return i-1
            }
        }
        return 0
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S852().peakIndexInMountainArray(intArrayOf(0,2,1,0)))
        }
    }

}