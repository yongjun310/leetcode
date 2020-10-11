package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet
import kotlin.math.log

/*
1598. Crawler Log Folder
Easy

70

9

Add to List

Share
The Leetcode file system keeps a log each time some user performs a change folder operation.

The operations are described below:

"../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
"./" : Remain in the same folder.
"x/" : Move to the child folder named x (This folder is guaranteed to always exist).
You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.

The file system starts in the main folder, then the operations in logs are performed.

Return the minimum number of operations needed to go back to the main folder after the change folder operations.



Example 1:



Input: logs = ["d1/","d2/","../","d21/","./"]
Output: 2
Explanation: Use this change folder operation "../" 2 times and go back to the main folder.
Example 2:



Input: logs = ["d1/","d2/","./","d3/","../","d31/"]
Output: 3
Example 3:

Input: logs = ["d1/","../","../","../"]
Output: 0


Constraints:

1 <= logs.length <= 103
2 <= logs[i].length <= 10
logs[i] contains lowercase English letters, digits, '.', and '/'.
logs[i] follows the format described in the statement.
Folder names consist of lowercase English letters and digits.
Accepted
11,099
Submissions
17,192
 */

class S1598 {
    fun minOperations(logs: Array<String>): Int {
        var c = 0
        for(i in logs.indices) {
            when(logs[i]) {
                "./" -> {

                }
                "../" -> {
                    if(c>0) {
                        c--
                    }
                }
                else -> {
                    c++
                }
            }
        }
        return if(c>=0) {
            c
        } else {
            0
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}