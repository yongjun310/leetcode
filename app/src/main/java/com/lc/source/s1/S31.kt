package com.lc.source.s1

import java.lang.StringBuilder
import java.util.Collections.sort
import kotlin.collections.ArrayList

/*
31. Next Permutation
Medium

4723

1654

Add to List

Share
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
Accepted
455,246
Submissions
1,367,649
 */

class S31{
    fun nextPermutation(nums: IntArray): Unit {
        for (i in nums.size-2 downTo 0) {
            if (i == 0 && nums[i] > nums[i+1]) {
                nums.reverse()
                break
            }
            if (nums[i] < nums[i+1]) {
                var minbigger = i+1
                for (j in i+1 until nums.size) {
                    if (nums[minbigger] >= nums[j] && nums[j] > nums[i]) {
                        minbigger = j
                    }
                }
                var temp = nums[i]
                nums[i] = nums[minbigger]
                nums[minbigger] = temp
                var s  = (nums.size-1 - i)/2
                while(s>0) {
                    temp = nums[i+s]
                    nums[i+s] = nums[nums.size-s]
                    nums[nums.size-s] = temp
                    s--
                }
                break
            }
        }
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S31().nextPermutation(intArrayOf(2,3,1,3,3)))
        }
    }
}