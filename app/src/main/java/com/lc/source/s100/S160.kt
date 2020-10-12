package com.lc.source.s100

import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.math.min

/*
160. Intersection of Two Linked Lists
Easy

4225

485

Add to List

Share
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.



Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.


Example 2:


Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.


Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Each value on each linked list is in the range [1, 10^9].
Your code should preferably run in O(n) time and use only O(1) memory.
Accepted
525,879
Submissions
1,264,714
 */

class S160 {
    class ListNode(var `val`: Int) {
      var next: ListNode? = null
    }

    /** initialize your data structure here. */
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        var la = 0
        var lb = 0
        var cur = headA
        while (cur?.next != null) {
            la++
            cur = cur.next
        }
        cur = headB
        while (cur?.next != null) {
            lb++
            cur = cur.next
        }
        var cura = headA
        cur = headB
        if(la>lb) {
            var d = la - lb
            while(d-->0) {
                cura = cura?.next
            }
        } else if(lb>la){
            var d = lb-la
            while(d-->0) {
                cur = cur?.next
            }
        }
        while(cur != cura && cur != null) {
            cur = cur.next
            cura = cura?.next
        }
        return cur
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * var obj = MinStack()
     * obj.push(x)
     * obj.pop()
     * var param_3 = obj.top()
     * var param_4 = obj.getMin()
     */

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}