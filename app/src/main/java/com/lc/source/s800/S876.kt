package com.lc.source.s800

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
876. Middle of the Linked List
Easy

1539

64

Add to List

Share
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.



Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.


Note:

The number of nodes in the given list will be between 1 and 100.
 */

class S876 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun middleNode(head: ListNode?): ListNode? {
        var len = 0
        var curN = head
        while(curN != null) {
            len++
            curN = curN.next
        }
        len = len/2
        curN = head
        while(len-->0) {
            curN = curN?.next
        }
        return curN
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}