package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1539. Kth Missing Positive Number
Easy

304

7

Add to List

Share
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Find the kth positive integer that is missing from this array.



Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.


Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for 1 <= i < j <= arr.length
Accepted
19,134
Submissions
35,970
 */

class S1539 {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        var c = 0
        var last = 0
        var ret = 0
        if(arr[0] - 1 >= k) {
            return k
        }
        for(i in arr.indices) {
            var dis = arr[i] - last - 1
            if(k-c<=dis) {
                ret = arr[i] + k - c
                break
            }
            c += dis
            last = arr[i]
        }
        if(c<k) {
            ret = last + k - c
        }
        return ret
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}