package com.lc.source.s1

import kotlin.collections.ArrayList

/*
19. Remove Nth Node From End of List
Medium

4589

279

Add to List

Share
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Follow up: Could you do this in one pass?



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
Accepted
775,478
Submissions
2,175,262
 */

class S19{
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var len = 0
        var cur = head
        while (cur != null) {
            len++
            cur = cur.next
        }
        if (len == 1 && n == 1) {
            return null
        }
        len = len - n
        cur = head
        var nex = head?.next
        if (len == 0) {
            return nex
        }
        while (len>1) {
            cur = nex
            nex = cur!!.next
            len--
        }
        cur?.next = nex?.next
        return head
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}