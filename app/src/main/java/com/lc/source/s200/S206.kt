package com.lc.source.s200

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.HashMap
import kotlin.math.min

/*
206. Reverse Linked List
Easy

5383

100

Add to List

Share
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

Accepted
1,122,964
Submissions
1,766,157
 */

class S206 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        var pre = head
        if(head?.next == null) {
            return head
        }
        if(head?.next?.next == null) {
            head.next?.next = head
            var t = head.next
            head.next = null
            return t
        }
        var cur = head?.next
        var next = cur?.next
        while(next != null) {
            cur?.next = pre
            pre = cur
            var t = next.next
            next.next = cur
            cur = next
            next = t
        }
        head?.next = null
        return cur
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}