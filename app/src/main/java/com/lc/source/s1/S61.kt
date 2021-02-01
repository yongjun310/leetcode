package com.lc.source.s1


/*
61. Rotate List
Medium

2033

1117

Add to List

Share
Given the head of a linked list, rotate the list to the right by k places.



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]


Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
Accepted
349,808
Submissions
1,105,454
 */

class S61{
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var cur = head
        var lengh = 0
        var loop = k
        while (cur != null) {
            cur = cur.next
            lengh++
        }
        if (lengh <= 1 || k == 0) {
            return head
        }
        loop %= lengh
        if (loop == 0) {
            return head
        }
        var index = lengh - loop
        var pre = head
        cur = head!!.next
        while (--index>0) {
            pre = cur
            cur = cur!!.next
        }
        pre!!.next = null
        var newHead = cur
        while (cur!!.next != null) {
            cur = cur.next
        }
        cur.next = head
        return newHead
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}