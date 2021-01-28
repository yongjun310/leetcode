package com.lc.source.s1

/*
46. Permutations
Medium

5285

124

Add to List

Share
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
Accepted
745,796
Submissions
1,126,185
 */

class S46{
    fun permute(nums: IntArray): List<List<Int>> {
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
            var subset = permute(subarr)
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
            var s = S46().permute(intArrayOf(1))
            print(s)
        }
    }
}