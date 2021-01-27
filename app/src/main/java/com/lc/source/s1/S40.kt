package com.lc.source.s1

/*
40. Combination Sum II
Medium

2407

84

Add to List

Share
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]


Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
Accepted
381,808
Submissions
764,862
 */

class S40{
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
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
                if (!retList.contains(ac)) {
                    retList.add(ac)
                }
            } else if(candidates.size>1){
                helper(candidates.sliceArray(1 until candidates.size), target - candidates[0], ac, retList)
            }
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S40().combinationSum2(intArrayOf(10,1,2,7,6,1,5), 8))
        }
    }
}