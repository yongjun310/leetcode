package com.lc.source.s300

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.min

/*
349. Intersection of Two Arrays
Easy

1024

1329

Add to List

Share
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.


Accepted
405,328
Submissions
638,680
 */

class S349{
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        var set = HashSet<Int>()
        for(e in nums1) {
            set.add(e)
        }
        var list = ArrayList<Int>()
        for(e in nums2) {
            if(set.contains(e) && !list.contains(e)) {
                list.add(e)
            }
        }
        return list.toIntArray()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}