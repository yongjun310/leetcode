package com.lc.source.s1100

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1154. Day of the Year
Easy

114

167

Add to List

Share
Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.



Example 1:

Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.
Example 2:

Input: date = "2019-02-10"
Output: 41
Example 3:

Input: date = "2003-03-01"
Output: 60
Example 4:

Input: date = "2004-03-01"
Output: 61


Constraints:

date.length == 10
date[4] == date[7] == '-', and all other date[i]'s are digits
date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.
Accepted
18,724
Submissions
38,026
 */

class S1154 {
    fun isLeapYear(y:Int): Boolean {
        if(y%4==0 && y%100!=0) {
            return true
        }
        if(y%400 == 0) {
            return true
        }
        return false
    }

    fun dayOfYear(date: String): Int {
        var arr = date.split('-')
        var intarr = intArrayOf(31,28,31,30,31,30,31,31,30,31,30,31)
        var ret = 0
        var y = arr[0].toInt()
        var m = arr[1].toInt()
        if(isLeapYear(y) && m>2) {
            ret++
        }
        for(i in 0..m-2) {
            ret += intarr[i]
        }
        ret += arr[2].toInt()
        return ret
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1154().dayOfYear("2004-01-09"))
        }
    }

}