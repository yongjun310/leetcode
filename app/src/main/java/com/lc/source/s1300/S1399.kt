import com.lc.source.s1100.S1160
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
1399. Count Largest Group
Easy

126

291

Add to List

Share
Given an integer n. Each number from 1 to n is grouped according to the sum of its digits.

Return how many groups have the largest size.



Example 1:

Input: n = 13
Output: 4
Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
Example 2:

Input: n = 2
Output: 2
Explanation: There are 2 groups [1], [2] of size 1.
Example 3:

Input: n = 15
Output: 6
Example 4:

Input: n = 24
Output: 5


Constraints:

1 <= n <= 10^4
Accepted
16,389
Submissions
25,141
*/
class S1399{
    fun countLargestGroup(n: Int): Int {
        var map = HashMap<Int, Int>()
        var s = 0
        for(i in 1..n) {
            var sum = 0
            var t = i
            while(t>0) {
                sum += t%10
                t /= 10
            }
            var v = map[sum]
            if(v != null) {
                map[sum] = v + 1
            } else {
                map[sum] = 1
            }
            if(s<map[sum]!!) {
                s = map[sum]!!
            }
        }
        var ret = 0
        var iterator = map.iterator()
        while(iterator.hasNext()) {
            var n = iterator.next().value
            if(n == s) {
                ret++
            }
        }
        return ret
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1399().countLargestGroup(38))
        }
    }
}
