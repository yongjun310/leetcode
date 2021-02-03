package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


/*
82. Remove Duplicates from Sorted List II
Medium

2632

122

Add to List

Share
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.



Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]


Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
Accepted
312,059
Submissions
798,187
 */

class S82{
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        var cur = head
        if (cur == null) {
            return cur
        }
        var newHead : ListNode? = null
        var newLast : ListNode? = null
        var hasDup = false
        while (cur != null) {
            if (cur.next != null && cur.next!!.`val` == cur.`val`) {
                hasDup = true
            } else {
                if (!hasDup) {
                    if (newHead == null) {
                        newHead = cur
                    }
                    if (newLast == null) {
                        newLast = cur
                    } else {
                        newLast.next = cur
                        newLast = cur
                    }
                }
                hasDup = false
            }
            cur = cur.next
        }
        newLast?.next = null
        return newHead
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var n1 = ListNode(1)
            var n2 = ListNode(2)
            var n3 = ListNode(2)
            n1.next = n2
            n2.next = n3
            print(S82().deleteDuplicates(n1))

        }
    }
}