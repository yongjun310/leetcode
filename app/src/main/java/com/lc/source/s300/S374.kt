package com.lc.source.s300

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.min

/*
374. Guess Number Higher or Lower
Easy

464

1886

Add to List

Share
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns 3 possible results:

-1: The number I picked is lower than your guess (i.e. pick < num).
1: The number I picked is higher than your guess (i.e. pick > num).
0: The number I picked is equal to your guess (i.e. pick == num).
Return the number that I picked.



Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
Example 3:

Input: n = 2, pick = 1
Output: 1
Example 4:

Input: n = 2, pick = 2
Output: 2


Constraints:

1 <= n <= 231 - 1
1 <= pick <= n
Accepted
171,371
Submissions
391,272
 */

class S374{
    fun guessNumber(n:Int):Int {
        var low = 1
        var high = n
        while(low<=high) {
            var mid = low + (high-low)/2
            var g = guess(mid)
            when(g) {
                0-> return mid
                1-> low = mid + 1
                -1 -> high = mid -1
            }
        }
        return -1
    }

    private fun guess(mid: Int): Int {
        return 0
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}