package com.lc.source.s400

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.min

/*
496. Next Greater Element I
Easy

1900

2436

Add to List

Share
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:

All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
Accepted
180,302
Submissions
278,997
 */

class S496{
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        var retarr = IntArray(nums1.size)
        var map = HashMap<Int, Int>()
        var stack = Stack<Int>()
        for(i in 0..nums2.size-1) {
            stack.clear()
            stack.push(nums2[i])
            var find = false
            for(j in i+1..nums2.size-1) {
                if(nums2[j]>nums2[i]) {
                    map.put(nums2[i], nums2[j])
                    find = true
                    break
                }
            }
            if(!find) {
                map.put(nums2[i], -1)
            }
        }
        for(i in 0 until nums1.size) {
            retarr[i] = map.get(nums1[i])!!
        }
        return retarr
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S496().nextGreaterElement(intArrayOf(4,1,2), intArrayOf(1,3,4,2)))
        }
    }
}