import com.lc.source.s1100.S1160
import java.util.*
import kotlin.collections.HashMap

/*
1200. Minimum Absolute Difference
Easy

378

24

Add to List

Share
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr


Example 1:

Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
Example 2:

Input: arr = [1,3,6,10,15]
Output: [[1,3]]
Example 3:

Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]


Constraints:

2 <= arr.length <= 10^5
-10^6 <= arr[i] <= 10^6
Accepted
44,039
Submissions
66,046
*/
class S1200{
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()
        var min = 1000000
        var list = ArrayList<ArrayList<Int>>()
        for(i in 1..arr.size-1) {
            if(arr[i]-arr[i-1]<min) {
                min = arr[i]-arr[i-1]
                list.clear()
                var pair = ArrayList<Int>()
                pair.add(arr[i-1])
                pair.add(arr[i])
                list.add(pair)
            } else if(arr[i]-arr[i-1]==min) {
                var pair = ArrayList<Int>()
                pair.add(arr[i-1])
                pair.add(arr[i])
                list.add(pair)
            }
        }
        return list
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
