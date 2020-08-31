package com.lc.source.s900

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
937. Reorder Data in Log Files
Easy

708

2146

Add to List

Share
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.
The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 The digit-logs should be put in their original order.

Return the final order of the logs.



Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]


Constraints:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.
Accepted
142,518
Submissions
263,107
 */

class S937 {

    class ComparatorOne : Comparator<String> {
        override fun compare(o1: String?, o2: String?): Int {
            if(o1 == null || o2 == null) {
                return 0
            }
            var substr1 = o1.substring(o1.indexOf(" ") + 1)
            var substr2 = o2.substring(o2.indexOf(" ") + 1)
            var isLetter1 = substr1[0].isLetter()
            var isLetter2 = substr2[0].isLetter()
            if(isLetter1 && isLetter2) {
                var c1 = substr1.compareTo(substr2)
                if(c1 == 0) {
                    return o1.compareTo(o2)
                } else {
                    return c1
                }
            } else if(isLetter1 && !isLetter2) {
                return -1
            } else if(!isLetter1 && isLetter2) {
                return 1
            } else {
                return 0
            }
        }

    }
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        logs.sortWith(ComparatorOne())
        return logs
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            S937().reorderLogFiles(arrayOf("8 fj dzz k", "5r 446 6 3", "63 gu psub", "5 ba iedrz", "6s 87979 5", "3r 587 01", "jc 3480612", "bb wsrd kp", "b aq cojj", "r5 6316 71"))
        }
    }

}