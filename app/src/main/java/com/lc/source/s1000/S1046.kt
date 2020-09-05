package com.lc.source.s1000

import com.lc.source.s900.S965
import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1046. Last Stone Weight
Easy

918

31

Add to List

Share
We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)



Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.


Note:

1 <= stones.length <= 30
1 <= stones[i] <= 1000
Accepted
140,547
Submissions
226,167
 */

class S1046 {
    fun indexOfHeaviest(stores: IntArray): Int {
        var max = 0
        for(i in 1..stores.size-1) {
            if(stores[i]<0) {
                continue
            }
            if(stores[i] > stores[max]) {
                max = i
            }
        }
        return max
    }
    fun lastStoneWeight(stones: IntArray): Int {
        while(true) {
            var h1 = indexOfHeaviest(stones)
            var i1 = stones[h1]
            stones[h1] = 0
            var h2 = indexOfHeaviest(stones)
            var i2 = stones[h2]
            stones[h2] = 0
            if(i2 <= 0) {
                return i1
            }
            if(i1 != i2) {
                stones[h1] = i1 - i2
            }
        }

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1046().lastStoneWeight(intArrayOf(2, 2)))
        }
    }

}