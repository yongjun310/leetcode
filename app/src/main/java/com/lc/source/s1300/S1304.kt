import com.lc.source.s1100.S1160
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
1304. Find N Unique Integers Sum up to Zero
Easy

370

219

Add to List

Share
Given an integer n, return any array containing n unique integers such that they add up to 0.



Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]


Constraints:

1 <= n <= 1000
Accepted
58,312
Submissions
76,371
*/
class S1304{
    fun sumZero(n: Int): IntArray {
        var arr = IntArray(n)
        var sum = 0
        for(i in 0..arr.size-2) {
            arr[i] = i
            sum += i
        }
        arr[arr.size-1] = -sum
        return arr
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
