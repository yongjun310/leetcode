package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1507. Reformat Date
Easy

59

150

Add to List

Share
Given a date string in the form Day Month Year, where:

Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
Year is in the range [1900, 2100].
Convert the date string to the format YYYY-MM-DD, where:

YYYY denotes the 4 digit year.
MM denotes the 2 digit month.
DD denotes the 2 digit day.


Example 1:

Input: date = "20th Oct 2052"
Output: "2052-10-20"
Example 2:

Input: date = "6th Jun 1933"
Output: "1933-06-06"
Example 3:

Input: date = "26th May 1960"
Output: "1960-05-26"


Constraints:

The given dates are guaranteed to be valid, so no error handling is necessary.
Accepted
12,488
Submissions
20,778
 */

class S1507 {
    fun reformatDate(date: String): String {
        var da = date.split(' ')
        var sb = StringBuilder()
        sb.append(da[2])
        sb.append('-')
        var month = ""
        month = when(da[1]) {
            "Jan" -> "01"
            "Feb" -> "02"
            "Mar" -> "03"
            "Apr" -> "04"
            "May" -> "05"
            "Jun" -> "06"
            "Jul" -> "07"
            "Aug" -> "08"
            "Sep" -> "09"
            "Oct" -> "10"
            "Nov" -> "11"
            else -> "12"
        }
        sb.append(month)
        sb.append("-")
        if(da[0].length == 3) {
            sb.append("0")
            sb.append(da[0].substring(0,1))
        } else {
            sb.append(da[0].substring(0,2))
        }
        return sb.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}