package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


/*
80. Remove Duplicates from Sorted Array II
Medium

1684

769

Add to List

Share
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.

Clarification:

Confused why the returned value is an integer, but your answer is an array?

Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}


Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3]
Explanation: Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively. It doesn't matter what you leave beyond the returned length.
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3]
Explanation: Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively. It doesn't matter what values are set beyond the returned length.


Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in ascending order.
Accepted
313,585
Submissions
682,289
 */

class S80{
    fun removeDuplicates(nums: IntArray): Int {
        var cur = 2
        for (i in 2 until nums.size) {
            var same = false
            if(nums[cur-1] == nums[cur-2]) {
                if (nums[i] != nums[cur-1]) {
                    nums[cur] = nums[i]
                } else {
                    same = true
                    if (i == nums.size-1) {
                        cur--
                    }
                }
            } else {
                nums[cur] = nums[i]
            }
            if (cur+1<nums.size && !same && i != nums.size-1) {
                cur++
            }
        }
        return cur+1
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S80().removeDuplicates(intArrayOf(1,1,1,1)))
        }
    }
}