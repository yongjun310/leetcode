package com.lc.source.s100

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap

/*
148. Sort List
Medium

4015

171

Add to List

Share
Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?



Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
Accepted
345,232
Submissions
741,615
 */

class S148 {
    class ListNode(var `val`: Int) {
         var next: ListNode? = null
    }

    fun sortList(head: ListNode?): ListNode? {
        var end = head
        var cur = head
        while(cur != null) {
            end = cur
            cur = cur.next
        }
        var arr = helper(head, end)
        return arr[0]
    }

    fun helper(head: ListNode?, end: ListNode?): Array<ListNode?> {
        if (head == null || head == end) {
            return arrayOf(head, head)
        }
        var lowhead : ListNode? = null
        var lowend = end
        var lowCur = lowhead
        var highhead : ListNode? = null
        var highend = end
        var highCur = highhead
        var tag = head
        var cur = head?.next
        while (cur != null ) {
            if (cur.`val` >= tag.`val`) {
                if (highhead == null) {
                    highhead = cur
                    highCur = cur
                } else {
                    highCur?.next = cur
                    highCur = cur
                }
            } else {
                if (lowhead == null) {
                    lowhead = cur
                    lowCur = cur
                } else {
                    lowCur?.next = cur
                    lowCur = cur
                }
            }
            if(cur == end) {
                break
            }
            cur = cur.next
        }
        lowend = lowCur
        highend = highCur
        if (lowend != null && lowhead != lowend) {
            var headArr = helper(lowhead, lowend)
            lowhead = headArr[0]
            headArr[1]?.next = tag
        } else {
            if (lowhead == null) {
                lowhead = tag
            } else {
                lowend?.next = tag
            }
        }
        if (highhead != null && highhead != highend) {
            var headArr = helper(highhead, highend)
            tag.next = headArr[0]
            highend = headArr[1]
        } else {
            if (highhead == null) {
                highend = tag
                tag.next = null
            } else {
                tag.next = highhead
                highend?.next = null
            }
        }
        return arrayOf(lowhead, highend)
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var v3 = ListNode(3)
            var v4 = ListNode(4)
            var v1 = ListNode(1)
            v3.next = v4
            v4.next = v1
            S148().sortList(v3)
        }
    }
}