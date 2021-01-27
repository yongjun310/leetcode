package com.lc.source.s1

/*
39. Combination Sum
Medium

5287

141

Add to List

Share
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
Example 4:

Input: candidates = [1], target = 1
Output: [[1]]
Example 5:

Input: candidates = [1], target = 2
Output: [[1,1]]


Constraints:

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500
Accepted
672,882
Submissions
1,142,451
 */

class S39{
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sortDescending()
        var retList = ArrayList<List<Int>>()
        var arr = ArrayList<Int>()
        helper(candidates, target, arr, retList)
        return retList
    }

    fun helper(candidates: IntArray, target: Int, arr: ArrayList<Int>,  retList: ArrayList<List<Int>>) {
        if (candidates.size>1) {
            //不选0元素
            helper(candidates.copyOfRange(1, candidates.size), target, arr, retList)
        }
        if (candidates[0]<=target) {
            //选0元素
            var ac = arr.clone() as ArrayList<Int>
            ac.add(candidates[0])
            if ( target - candidates[0] == 0) {
                retList.add(ac)
            } else {
                helper(candidates, target - candidates[0], ac, retList)
            }
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S39().combinationSum(intArrayOf(2,3,6,7), 7))
        }
    }
}