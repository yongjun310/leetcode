package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


/*
77. Combinations
Medium

1997

79

Add to List

Share
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

You may return the answer in any order.



Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]


Constraints:

1 <= n <= 20
1 <= k <= n
Accepted
340,781
Submissions
596,118
 */

class S77{
    fun combine(n: Int, k: Int): List<List<Int>> {
        var retList = ArrayList<List<Int>>()
        helper(1, n, k, ArrayList(), retList)
        return retList
    }

    fun helper(s: Int, e: Int, n:Int, list:ArrayList<Int>, arrayList: ArrayList<List<Int>>) {
        for (i in s..e) {
            var cl = if (list == null) ArrayList() else list.clone() as ArrayList<Int>
            cl.add(i)
            if (n == 1) {
                arrayList.add(cl)
            } else {
                helper(i + 1, e, n - 1, cl, arrayList)
            }
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S77().combine(4, 2))
        }
    }
}