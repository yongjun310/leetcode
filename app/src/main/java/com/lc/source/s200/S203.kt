package com.lc.source.s200

import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.HashMap
import kotlin.math.min

/*
203. Remove Linked List Elements
Easy

2067

99

Add to List

Share
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
Accepted
391,486
Submissions
1,007,401
 */

class S203 {
    class ListNode(var `val`: Int) {
       var next: ListNode? = null
    }

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var ret = head
        while(ret?.`val` == `val`) {
            ret = ret.next
        }
        var cur = ret
        while(cur != null) {
            if(cur.next?.`val` == `val`) {
                var t = cur.next?.next
                while (t != null && t?.`val` == `val`) {
                    t = t.next
                }
                cur.next = t
            }
            cur = cur.next
        }
        return ret
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}