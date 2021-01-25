package com.lc.source.s1

import kotlin.collections.ArrayList

/*
506. Relative Ranks
Easy

289

572

Add to List

Share
Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:

Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:

N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.
Accepted
57,307
Submissions
112,874
 */

class S18{
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        var retL = ArrayList<List<Int>>()
        for (i in 0..nums.size-3) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue
            }
            var ta = threeSum(nums, i+1, target-nums[i])
            for (a in ta) {
                var l = ArrayList<Int>()
                l.add(nums[i])
                l.addAll(a)
                retL.add(l)
            }
        }
        return retL
    }

    fun threeSum(nums: IntArray, si: Int, tsum: Int): List<List<Int>> {
        var retL = ArrayList<List<Int>>()
        for (i in si..nums.size-2) {
            if (i>si && nums[i] == nums[i-1]) {
                continue
            }
            var left = i+1
            var right = nums.size-1
            while (left<right) {
                var sum = nums[i] + nums[left] + nums[right]
                if (sum == tsum) {
                    var l = listOf(nums[i], nums[left], nums[right])
                    if (!retL.contains(l)) {
                        retL.add(l)
                    }
                    left++
                    right--
                } else if (sum < tsum) {
                    left++
                } else {
                    right--
                }
            }
        }
        return retL
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S18().fourSum(intArrayOf(-1,-5,-5,-3,2,5,0,4), -7))
        }
    }
}