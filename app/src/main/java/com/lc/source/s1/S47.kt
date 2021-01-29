package com.lc.source.s1

/*
47. Permutations II
Medium

2683

74

Add to List

Share
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.



Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
Accepted
426,772
Submissions
868,695
 */

class S47{
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        return helper(nums).toList()
    }

    fun helper(nums: IntArray): Set<List<Int>> {
        var set = HashSet<ArrayList<Int>>()
        if (nums.size == 1) {
            set.add(arrayListOf(nums[0]))
            return set
        }
        if (nums.size == 2) {
            set.add(arrayListOf(nums[0], nums[1]))
            set.add(arrayListOf(nums[1], nums[0]))
            return set
        }
        for (j in nums.indices) {
            var subarr = IntArray(nums.size-1)
            var t = 0
            for (k in nums.indices) {
                if (k != j) {
                    subarr[t++] = nums[k]
                }
            }
            var subset = permuteUnique(subarr)
            var iterator = subset.iterator()
            while (iterator.hasNext()) {
                var tl = ArrayList<Int>()
                var item = iterator.next() as ArrayList
                tl.add(nums[j])
                tl.addAll(item)
                var te = ArrayList<Int>()
                te.addAll(item)
                te.add(nums[j])
                set.add(tl)
                set.add(te)
            }
        }

        return set
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var s = S47().permuteUnique(intArrayOf(1,1,2))
            print(s)
        }
    }
}