package com.lc.source.s1000

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1005. Maximize Sum Of Array After K Negations
Easy

391

38

Add to List

Share
Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.



Example 1:

Input: A = [4,2,3], K = 1
Output: 5
Explanation: Choose indices (1,) and A becomes [4,-2,3].
Example 2:

Input: A = [3,-1,0,2], K = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
Example 3:

Input: A = [2,-3,-1,5,-4], K = 2
Output: 13
Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].


Note:

1 <= A.length <= 10000
1 <= K <= 10000
-100 <= A[i] <= 100
Accepted
28,783
Submissions
55,960
 */

class S1005 {
    fun largestSumAfterKNegations(A: IntArray, K: Int): Int {
        A.sort()
        var c = K
        var sum = 0
        var f = 0
        for(i in 0..A.size-1) {
            if(A[i]<0){
                if(c-->0) {
                    A[i] = -A[i]
                }
            } else if(c>0){
                f = c%2
                if(f == 1) {
                    var a = false
                    if(i>0) {
                        a = A[i]>A[i-1]
                    }
                    if(a) {
                        sum = sum - 2 * A[i - 1] + A[i]
                        continue
                    } else {
                        A[i] = -A[i]
                    }
                }
                c = 0
            }
            sum += A[i]

        }
        return sum
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1005().largestSumAfterKNegations(intArrayOf(-8,3,-5,-3,-5,-2),6))
        }
    }

}