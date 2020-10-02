import com.lc.source.s1100.S1160
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
1295. Find Numbers with Even Number of Digits
Easy

448

62

Add to List

Share
Given an array nums of integers, return how many of them contain an even number of digits.


Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore only 12 and 7896 contain an even number of digits.
Example 2:

Input: nums = [555,901,482,1771]
Output: 1
Explanation:
Only 1771 contains an even number of digits.


Constraints:

1 <= nums.length <= 500
1 <= nums[i] <= 10^5
Accepted
171,397
Submissions
212,607
*/
class S1295{
    fun findNumbers(nums: IntArray): Int {
        var c = 0
        for(i in nums.indices) {
            when {
                nums[i] in 10..99  -> c++
                nums[i] in 1000..9999  -> c++
                nums[i] in 100000..999999  -> c++
            }
        }
        return c
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1295().findNumbers(intArrayOf(100000)))
        }
    }
}
