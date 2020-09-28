import com.lc.source.s1100.S1160
import java.util.*
import kotlin.collections.HashMap

/*
1207. Unique Number of Occurrences
Easy

481

21

Add to List

Share
Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.



Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true


Constraints:

1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
Accepted
61,157
Submissions
85,231
*/
class S1207{
    fun uniqueOccurrences(arr: IntArray): Boolean {
        var set = HashSet<Int>()
        arr.sort()
        var last = arr[0]
        var c = 1
        for(i in 1..arr.size-1) {
            if(arr[i] == last) {
                c++
            } else {
                last = arr[i]
                var exist = set.add(c)
                if(!exist) {
                    return false
                } else {
                    c = 1
                }
            }
            if(i == arr.size-1) {
                var exist = set.add(c)
                if(!exist) {
                    return false
                }
            }
        }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
