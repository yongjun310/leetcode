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
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
Accepted
407,638
Submissions
788,509
 */

class S350{
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        var map = HashMap<Int, Int>()
        for(e in nums1) {
            map.put(e, if(map.get(e) != null) map.get(e) as Int + 1 else 1)
        }
        var list = ArrayList<Int>()
        for(e in nums2) {
            if(map.contains(e)) {
                var cur = map.get(e)
                if(cur == 1) {
                    map.remove(e)
                } else {
                    map.put(e, cur as Int - 1)
                }
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