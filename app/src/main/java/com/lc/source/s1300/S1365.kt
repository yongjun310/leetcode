import com.lc.source.s1100.S1160
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
1365. How Many Numbers Are Smaller Than the Current Number
Easy

1020

28

Add to List

Share
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.



Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]


Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100
Accepted
123,356
Submissions
143,901
*/
class S1365{
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        var reta = IntArray(nums.size)
        for(i in nums.indices) {
            var c = 0
            for(j in nums.indices) {
                if(i != j && nums[i]>nums[j]) {
                    c++
                }
            }
            reta[i] = c
        }
        return reta
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
