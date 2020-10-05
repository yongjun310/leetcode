import com.lc.source.s1100.S1160
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
1346. Check If N and Its Double Exist
Easy

219

35

Add to List

Share
Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]


Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
Example 2:

Input: arr = [7,1,14,11]
Output: true
Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
Example 3:

Input: arr = [3,1,7,11]
Output: false
Explanation: In this case does not exist N and M, such that N = 2 * M.


Constraints:

2 <= arr.length <= 500
-10^3 <= arr[i] <= 10^3
Accepted
59,350
Submissions
159,471
*/
class S1346{
    var set = HashSet<Int>()
    fun checkIfExist(arr: IntArray): Boolean {
        set.clear()
        var hasZero = false
        for(i in arr.indices) {
            if(arr[i] == 0) {
                if(hasZero) {
                    return true
                }
                hasZero = true
            }
            set.add(arr[i])
        }
        for(i in arr.indices) {
            if(set.contains(2*arr[i]) && arr[i] != 0) {
                return true
            }
        }
        return false
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
