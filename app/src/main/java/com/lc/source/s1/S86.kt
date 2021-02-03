package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


/*
86. Partition List
Medium

1804

363

Add to List

Share
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.



Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]


Constraints:

The number of nodes in the tree is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
Accepted
246,317
Submissions
570,217
 */

class S86{
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun partition(head: ListNode?, x: Int): ListNode? {
        var cur = head
        if (cur == null || cur.next == null) {
            return cur
        }
        var newSH : ListNode? = null
        var newMH : ListNode? = null
        var newSC : ListNode? = null
        var newMC : ListNode? = null
        while (cur != null) {
            if (cur.`val` < x) {
                if (newSH == null) {
                    newSH = cur
                    newSC = cur
                } else {
                    newSC?.next = cur
                    newSC = cur
                }
            } else {
                if (newMH == null) {
                    newMH = cur
                    newMC = cur
                } else {
                    newMC?.next = cur
                    newMC = cur
                }
            }
            cur = cur.next
        }
        newMC?.next = null
        newSC?.next = newMH
        if (newSH == null) {
            return head
        }
        return newSH
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var n1 = ListNode(1)
            var n2 = ListNode(4)
            var n3 = ListNode(3)
            var n4 = ListNode(2)
            var n5 = ListNode(5)
            var n6 = ListNode(2)
            n1.next = n2
            n2.next = n3
            n3.next = n4
            n4.next = n5
            n5.next = n6
            print(S86().partition(n1, 3))

        }
    }
}