package com.lc.source.s1400

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1496. Path Crossing
Easy

191

6

Add to List

Share
Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

Return True if the path crosses itself at any point, that is, if at any time you are on a location you've previously visited. Return False otherwise.



Example 1:



Input: path = "NES"
Output: false
Explanation: Notice that the path doesn't cross any point more than once.
Example 2:



Input: path = "NESWW"
Output: true
Explanation: Notice that the path visits the origin twice.


Constraints:

1 <= path.length <= 10^4
path will only consist of characters in {'N', 'S', 'E', 'W}
Accepted
18,062
Submissions
32,330
 */

class S1496 {
    fun isPathCrossing(path: String): Boolean {
        var set = HashSet<String>()
        var curx = 0
        var cury = 0
        set.add("0,0")
        for(i in path.indices) {
            when(path[i]) {
                'N'-> {
                    cury++
                }
                'S'-> {
                    cury--

                }
                'E'-> {
                    curx++

                }
                'W'-> {
                    curx--

                }
            }
            var suc = set.add("$curx,$cury")
            if(!suc) {
                return true
            }
        }
        return false
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1496().isPathCrossing("NESWW"))
        }
    }

}