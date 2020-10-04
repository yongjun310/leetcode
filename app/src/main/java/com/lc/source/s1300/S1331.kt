import com.lc.source.s1100.S1160
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
1331. Rank Transform of an Array
Easy

303

23

Add to List

Share
Given an array of integers arr, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.


Example 1:

Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
Example 2:

Input: arr = [100,100,100]
Output: [1,1,1]
Explanation: Same elements share the same rank.
Example 3:

Input: arr = [37,12,28,9,100,56,80,5,12]
Output: [5,3,4,2,8,6,7,1,3]


Constraints:

0 <= arr.length <= 105
-109 <= arr[i] <= 109
Accepted
19,557
Submissions
33,891
*/
class S1331{
    fun arrayRankTransform(arr: IntArray): IntArray {
        var sarr = IntArray(arr.size)
        for(i in arr.indices) {
            sarr[i] = arr[i]
        }
        sarr.sort()
        for(i in sarr.indices) {
            if(i>0 && sarr[i] == sarr[i-1]) {
                sarr[i-1] = Int.MAX_VALUE
            }
        }
        sarr.sort()
        var ia = IntArray(arr.size)
        for(i in arr.indices) {
            ia[i] = sarr.indexOf(arr[i]) + 1
        }
        return ia
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
