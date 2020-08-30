package com.lc.source.s900

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
933. Number of Recent Calls
Easy

311

1763

Add to List

Share
Write a class RecentCounter to count recent requests.

It has only one method: ping(int t), where t represents some time in milliseconds.

Return the number of pings that have been made from 3000 milliseconds ago until now.

Any ping with time in [t - 3000, t] will count, including the current ping.

It is guaranteed that every call to ping uses a strictly larger value of t than before.



Example 1:

Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
Output: [null,1,2,3,3]


Note:

Each test case will have at most 10000 calls to ping.
Each test case will call ping with strictly increasing values of t.
Each call to ping will have 1 <= t <= 10^9.


Accepted
48,339
Submissions
67,128
 */

class S933 {
    var queue = LinkedBlockingQueue<Int>()
    fun ping(t: Int): Int {
        while(queue.isNotEmpty()) {
            var ele = queue.first()
            if(ele>=t-3000) {
                break
            }
            queue.poll()
        }
        queue.put(t)
        return queue.size
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}