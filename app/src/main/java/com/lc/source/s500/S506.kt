package com.lc.source.s500

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

class S506{
    fun findRelativeRanks(nums: IntArray): Array<String> {
        var sn = nums.clone()
        sn.sort()
        var strArr = ArrayList<String>()
        for(e in nums) {
            var index = sn.binarySearch(e)
            index = nums.size - index
            if(index<=3) {
                strArr.add(
                    when(index) {
                        1->{
                            "Gold Medal"
                        }
                        2->{
                            "Silver Medal"
                        }
                        else->{
                            "Bronze Medal"
                        }
                    }
                )
            } else {
                strArr.add(index.toString())
            }
        }
        return strArr.toTypedArray()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S506().findRelativeRanks(intArrayOf(5,4,3,2,1)))
        }
    }
}