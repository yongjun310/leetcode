import com.lc.source.s1100.S1160
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
1287. Element Appearing More Than 25% In Sorted Array
Easy

298

24

Add to List

Share
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.

Return that integer.



Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6


Constraints:

1 <= arr.length <= 10^4
0 <= arr[i] <= 10^5
Accepted
28,109
Submissions
46,643
*/
class S1287{
    fun findSpecialInteger(arr: IntArray): Int {
        if(arr.size == 1) {
            return arr[0]
        }
        var i = 0
        while(i < (arr.size-1)) {
            if((i+arr.size/4)<arr.size && arr[i+arr.size/4] == arr[i]) {
                return arr[i]
            } else {
                i++
            }
        }
        return -1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
