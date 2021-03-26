package com.lc.source.s100

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

/*
143. Reorder List
Medium

2981

145

Add to List

Share
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]


Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
Accepted
313,233
Submissions
765,927
 */

class S143 {
    class ListNode(var `val`: Int) {
         var next: ListNode? = null
    }

    fun reorderList(head: ListNode?): Unit {
        var cur = head
        var count = 0
        while (cur != null) {
            count++
            cur = cur.next
        }
        if (count <= 2) {
            return
        }
        var half = (count+1)/2
        cur = head
        var sc = 1
        while (sc++<half) {
            cur = cur!!.next
        }
        var lastHalfHead = cur!!.next
        cur.next = null
        sc = 1
        var lc = count/2
        var pre = lastHalfHead
        cur = pre!!.next
        pre!!.next = null
        while (sc<lc) {
            var temp = cur!!.next
            cur.next = pre
            pre = cur
            cur = temp
            sc++
        }
        lastHalfHead = pre
        cur = head
        var lastcur = lastHalfHead
        sc = 1
        while (sc++<half) {
            var temp = cur!!.next
            cur.next = lastcur
            var lasttemp = lastcur!!.next
            cur.next!!.next = temp
            cur = temp
            lastcur = lasttemp
        }
        if (lastcur != null) {
            cur!!.next = lastcur
        }
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var n1 = ListNode(1)
            var n4 = ListNode(2)
            var n2 = ListNode(3)
            var n3 = ListNode(4)
            var n5 = ListNode(5)
            n1.next = n4
            n4.next = n2
            n2.next = n3
            n3.next = n5
            S143().reorderList(n1)
        }
    }
}