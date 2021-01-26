package com.lc.source.s1

import java.lang.StringBuilder
import kotlin.collections.ArrayList

/*
24. Swap Nodes in Pairs
Medium

3220

199

Add to List

Share
Given a linked list, swap every two adjacent nodes and return its head.



Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]


Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100

 */

class S24{
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun swapPairs(head: ListNode?): ListNode? {
        var node = swap(head)
        return node
    }

    fun swap(cur: ListNode?): ListNode? {
        var next: ListNode? = cur?.next ?: return cur
        var nextCur = next?.next
        next?.next = cur
        cur.next = swap(nextCur)
        return next
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}