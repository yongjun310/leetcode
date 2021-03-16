package com.lc.source.s1

/*
45. Jump Game II
Medium

3775

173

Add to List

Share
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 105
Accepted
320,548
Submissions
1,017,792
 */

class S45{
    fun jump(nums: IntArray): Int {
        for (i in nums.size-1 downTo 0) {
            if (nums[i] == 0 && i != nums.size-1) {
                nums[i] = 200
            } else if (i + nums[i] >= nums.size-1) {
                if (i == nums.size-1) {
                    nums[i] = 0
                } else {
                    nums[i] = 1
                }
            } else {
                var min = 200
                for (j in 1..nums[i]) {
                    var temp = nums[i+j] + 1
                    if (min > temp) {
                        min = temp
                    }
                }
                nums[i] = min
            }
        }
        return nums[0]
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var s = S45().jump(intArrayOf(2,3,0,1,4))
            print(s)
        }
    }
}