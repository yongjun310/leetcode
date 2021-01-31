package com.lc.source.s1

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
50. Pow(x, n)
Medium

2059

3568

Add to List

Share
Implement pow(x, n), which calculates x raised to the power n (i.e. xn).



Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
Accepted
586,746
Submissions
1,901,552
 */

class S50{
    fun myPow(x: Double, n: Int): Double {
        if (n==0) {
            return 1.0
        } else if (n == 1) {
            return x
        } else if (n == -1) {
            return 1/x
        } else if (x == 1.0 || x == -1.0) {
            return if(n%2 == 0 || x == 1.0) 1.0 else -1.0
        } else if (n < -200000) {
            return 0.0
        }
        var munus = n<0
        var m = n
        if (munus) {
            m = -n
        }
        var rd = 1.0
        var xr = x
        while (m > 0) {
            if (m%2 == 1) {
                rd *= xr

            }
            xr *= xr
            m /= 2

        }
        if (munus) {
            rd = 1/rd
        }
        return rd
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S50().myPow(2.0,10))
        }
    }
}