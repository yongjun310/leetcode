import com.lc.source.s1100.S1160
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
1394. Find Lucky Integer in an Array
Easy

261

8

Add to List

Share
Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.

Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.



Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
Example 2:

Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
Example 3:

Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.
Example 4:

Input: arr = [5]
Output: -1
Example 5:

Input: arr = [7,7,7,7,7,7,7]
Output: 7


Constraints:

1 <= arr.length <= 500
1 <= arr[i] <= 500
Accepted
36,638
Submissions
57,553
*/
class S1394{
    fun findLucky(arr: IntArray): Int {
        var map = HashMap<Int, Int>()
        for(i in arr.indices) {
            var v = map[arr[i]]
            if(v!=null) {
                map[arr[i]] = v+1
            } else {
                map[arr[i]] = 1
            }
        }
        var luck = -1
        var iterator = map.iterator()
        while(iterator.hasNext()) {
            var next = iterator.next()
            if(next.key == next.value && next.key>luck) {
                luck = next.key
            }
        }
        return luck
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1394().findLucky(intArrayOf(2,2,3,4)))
        }
    }
}
