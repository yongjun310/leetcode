import com.lc.source.s1100.S1160
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
1281. Subtract the Product and Sum of Digits of an Integer
Easy

360

109

Add to List

Share
Given an integer number n, return the difference between the product of its digits and the sum of its digits.


Example 1:

Input: n = 234
Output: 15
Explanation:
Product of digits = 2 * 3 * 4 = 24
Sum of digits = 2 + 3 + 4 = 9
Result = 24 - 9 = 15
Example 2:

Input: n = 4421
Output: 21
Explanation:
Product of digits = 4 * 4 * 2 * 1 = 32
Sum of digits = 4 + 4 + 2 + 1 = 11
Result = 32 - 11 = 21


Constraints:

1 <= n <= 10^5
Accepted
101,757
Submissions
119,151
*/
class S1281{
    fun subtractProductAndSum(n: Int): Int {
        var product = 1
        var sum = 0
        var m = n
        while (m>0) {
            var c = m%10
            product *= c
            sum += c
            m = m/10
        }
        return product-sum
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
