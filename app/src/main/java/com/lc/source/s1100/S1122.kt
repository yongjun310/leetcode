package com.lc.source.s1100

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1122. Relative Sort Array
Easy

784

54

Add to List

Share
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.



Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]


Constraints:

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
Each arr2[i] is distinct.
Each arr2[i] is in arr1.
Accepted
67,184
Submissions
99,401
 */

class S1122 {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        var arrCount = IntArray(arr2.size)
        var other = ArrayList<Int>()
        for(i in 0..arr1.size-1) {
            var ind = arr2.indexOf(arr1[i])
            if(ind>=0) {
                arrCount[ind]++
            } else {
                other.add(arr1[i])
            }
        }
        var ind = 0
        for(i in 0..arr2.size-1) {
            while(arrCount[i]-->0) {
                arr1[ind++] = arr2[i]
            }
        }
        other.sort()
        for(i in 0..other.size-1) {
            arr1[ind++] = other[i]
        }
        return arr1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}