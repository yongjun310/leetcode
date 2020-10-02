import com.lc.source.s1100.S1160
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
1299. Replace Elements with Greatest Element on Right Side
Easy

486

108

Add to List

Share
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.



Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]


Constraints:

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
Accepted
78,209
Submissions
104,481
*/
class S1295{
    fun replaceElements(arr: IntArray): IntArray {
        for(i in arr.size-2 downTo 0) {
            if(arr[i] < arr[i+1]) {
                arr[i] = arr[i+1]
            }
        }
        for(i in 0..arr.size-2) {
            arr[i] = arr[i+1]
        }
        arr[arr.size-1] = -1
        return arr
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
