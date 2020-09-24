package com.lc.source.s1100

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1128. Number of Equivalent Domino Pairs
Easy

226

125

Add to List

Share
Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].



Example 1:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1


Constraints:

1 <= dominoes.length <= 40000
1 <= dominoes[i][j] <= 9
Accepted
26,086
Submissions
55,623
 */

class S1128 {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        var count = 0
        var map = HashMap<String, Int>()
        for(i in 0..dominoes.size-1) {
            var cur = dominoes[i]
            if(cur[0] > cur[1]) {
                var t = cur[0]
                cur[0] = cur[1]
                cur[1] = t
            }
            var str = cur[0].toString()+cur[1]
            var value = map.get(str)
            if(value != null) {
                map.put(str, value+1)
            } else {
                map.put(str, 1)
            }
        }
        var it = map.iterator()
        while(it.hasNext()) {
            var c = it.next()
            count += c.value * (c.value-1)/2
        }
        return count
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1128().numEquivDominoPairs(arrayOf<IntArray>(intArrayOf(1,2),intArrayOf(2,1),intArrayOf(3,4),intArrayOf(5,6))))
        }
    }

}