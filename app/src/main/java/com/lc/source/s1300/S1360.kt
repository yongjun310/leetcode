import com.lc.source.s1100.S1160
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
1360. Number of Days Between Two Dates
Easy

72

414

Add to List

Share
Write a program to count the number of days between two dates.

The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.



Example 1:

Input: date1 = "2019-06-29", date2 = "2019-06-30"
Output: 1
Example 2:

Input: date1 = "2020-01-15", date2 = "2019-12-31"
Output: 15


Constraints:

The given dates are valid dates between the years 1971 and 2100.
Accepted
15,037
Submissions
31,507
*/
class S1360{
    fun daysBetweenDates(date1: String, date2: String): Int {
        var c = Calendar.getInstance()
        c.set(Integer.parseInt(date1.substring(0, 4)), Integer.parseInt(date1.substring(5, 7))-1,Integer.parseInt(date1.substring(8, 10)))
        var t1 = c.timeInMillis
        c.set(Integer.parseInt(date2.substring(0, 4)), Integer.parseInt(date2.substring(5, 7))-1,Integer.parseInt(date2.substring(8, 10)))
        var t2 = c.timeInMillis
        return (Math.abs(t1-t2)/(1000*24*3600)).toInt()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
