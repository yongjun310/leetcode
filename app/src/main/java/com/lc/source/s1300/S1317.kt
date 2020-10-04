import com.lc.source.s1100.S1160
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
1317. Convert Integer to the Sum of Two No-Zero Integers
Easy

120

122

Add to List

Share
Given an integer n. No-Zero integer is a positive integer which doesn't contain any 0 in its decimal representation.

Return a list of two integers [A, B] where:

A and B are No-Zero integers.
A + B = n
It's guarateed that there is at least one valid solution. If there are many valid solutions you can return any of them.



Example 1:

Input: n = 2
Output: [1,1]
Explanation: A = 1, B = 1. A + B = n and both A and B don't contain any 0 in their decimal representation.
Example 2:

Input: n = 11
Output: [2,9]
Example 3:

Input: n = 10000
Output: [1,9999]
Example 4:

Input: n = 69
Output: [1,68]
Example 5:

Input: n = 1010
Output: [11,999]


Constraints:

2 <= n <= 10^4
Accepted
17,680
Submissions
31,142
*/
class S1317{
    fun isNoZero(n:Int): Boolean {
        var m = n
        while(m>0) {
            if(m%10 == 0) {
                return false
            }
            m /= 10
        }
        return true
    }

    fun getNoZeroIntegers(n: Int): IntArray {
        var ia = IntArray(2)
        for(i in 0..n-1) {
            if(isNoZero(i) && isNoZero(n-i)) {
                ia[0] = i
                ia[1] = n-i
            }
        }
        return ia
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1317().getNoZeroIntegers(1010))
        }
    }
}
