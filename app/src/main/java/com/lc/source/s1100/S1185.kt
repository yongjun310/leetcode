import com.lc.source.s1100.S1160
import java.util.*

/*
1185. Day of the Week
Easy

127

1137

Add to List

Share
Given a date, return the corresponding day of the week for that date.

The input is given as three integers representing the day, month and year respectively.

Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.



Example 1:

Input: day = 31, month = 8, year = 2019
Output: "Saturday"
Example 2:

Input: day = 18, month = 7, year = 1999
Output: "Sunday"
Example 3:

Input: day = 15, month = 8, year = 1993
Output: "Sunday"


Constraints:

The given dates are valid dates between the years 1971 and 2100.
Accepted
25,102
Submissions
39,555
*/
class S1185{
    fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
        var c = Calendar.getInstance()
        c.set(year, month-1, day)
        when(c.time.day) {
            1-> return "Monday"
            2-> return "Tuesday"
            3-> return "Wednesday"
            4-> return "Thursday"
            5-> return "Friday"
            6-> return "Saturday"
            else -> return "Sunday"
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
