package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


/*
92. Reverse Linked List II
Medium

3276

169

Add to List

Share
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
Accepted
325,407
Submissions
805,354
 */

class S92{
    class ListNode(var `val`: Int) {
         var next: ListNode? = null
    }

    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        if (head == null || m == n) {
            return head
        }
        //反转的前一个
        var first: ListNode? = null
        var mn : ListNode? = null
        var pre = head
        var cur = head.next
        var count = 1
        if (m == 1) {
            mn = head
        }
        while (cur != null) {
            count++
            if (m == count) {
                first = pre
                mn = cur
            }
            if (n == count) {
                if (first != null) {
                    var temp = first.next
                    first.next = cur
                    temp?.next = cur.next
                } else {
                    mn?.next = cur.next
                    if (first == null) {
                        cur.next = pre
                        return cur
                    }
                }
            }
            var temp = cur.next
            if (first != null || mn != null) {
                cur.next = pre
            }
            pre = cur
            cur = temp
            if (n == count) {
                break
            }
        }
        return if (first!= null) head else mn
    }

//    [[1], [4, 4, 1], [], [4, 4], [4], [4, 4, 4], [1, 4], [4, 1, 4], [4, 4, 4, 1, 4], [4, 4, 1, 4], [4, 4, 4, 4], [4, 4, 4, 1], [4, 1]]
//    [[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var n1 = ListNode(1)
            var n2 = ListNode(2)
            n1.next = n2
            print(S92().reverseBetween(n1, 1, 2))
        }
    }
}