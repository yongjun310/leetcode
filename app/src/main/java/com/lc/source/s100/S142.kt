package com.lc.source.s100

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

/*
142. Linked List Cycle II
Medium

3933

294

Add to List

Share
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Notice that you should not modify the linked list.



Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.


Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.


Follow up: Can you solve it using O(1) (i.e. constant) memory?

Accepted
431,422
Submissions
1,081,759
 */

class S142 {
    class ListNode(var `val`: Int) {
         var next: ListNode? = null
    }

    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        var dh = ListNode(-1)
        dh.next = head
        var x1 = dh.next
        var x2 = dh?.next?.next
        if (head.next == head) {
            return head
        }
        while (true) {
            if (x1 == null || x2 == null) {
                return null
            } else if (x1 == x2) {
                break
            }
            x1 = x1!!.next
            x2 = x2!!.next?.next
        }
        x1 = dh
        while (x1 != x2) {
            x1 = x1?.next
            x2 = x2?.next
        }
        return x1
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var s = "leetcode"
            var arr = listOf("leet","code")
        }
    }
}