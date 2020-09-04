package com.lc.source.s1000

import com.lc.source.s900.S965
import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1033. Moving Stones Until Consecutive
Easy

83

433

Add to List

Share
Three stones are on a number line at positions a, b, and c.

Each turn, you pick up a stone at an endpoint (ie., either the lowest or highest position stone),
and move it to an unoccupied position between those endpoints.  Formally, let's say the stones are currently at positions x, y, z with x < y < z.
You pick up the stone at either position x or position z, and move that stone to an integer position k, with x < k < z and k != y.

The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.

When the game ends, what is the minimum and maximum number of moves that you could have made?
 Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves]



Example 1:

Input: a = 1, b = 2, c = 5
Output: [1,2]
Explanation: Move the stone from 5 to 3, or move the stone from 5 to 4 to 3.
Example 2:

Input: a = 4, b = 3, c = 2
Output: [0,0]
Explanation: We cannot make any moves.
Example 3:

Input: a = 3, b = 5, c = 1
Output: [1,2]
Explanation: Move the stone from 1 to 4; or move the stone from 1 to 2 to 4.


Note:

1 <= a <= 100
1 <= b <= 100
1 <= c <= 100
a != b, b != c, c != a



Accepted
13,492
Submissions
32,106
 */

class S1033 {
    fun numMovesStones(a: Int, b: Int, c: Int): IntArray {
        var min = Math.min(a, Math.min(b, c))
        var max = Math.max(a, Math.max(b, c))
        var mid = a xor min xor max xor b xor c
        var maxdf = max-min
        var mindf = Math.min(max-mid, mid-min)
        var minm = 0
        if(mindf <= 2) {
            if(maxdf == 2) {
                minm = 0
            } else {
                minm = 1
            }
        } else {
            minm = mindf-1
            if(minm>2) {
                minm = 2
            }
        }
        return intArrayOf(minm, maxdf - 2)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1033().numMovesStones(1, 9, 5))
        }
    }

}