package com.lc.source.s100

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap

/*
147. Insertion Sort List
Medium

986

680

Add to List

Share
Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.




Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]


Constraints:

The number of nodes in the list is in the range [1, 5000].
-5000 <= Node.val <= 5000
Accepted
227,513
Submissions
510,609
 */

class S147 {
    class ListNode(var `val`: Int) {
         var next: ListNode? = null
    }

    fun insertionSortList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        var newHead = head
        var newCur = head.next
        head.next = null
        while (newCur != null) {
            var newInput = newCur
            var next = newInput.next
            if (newHead!!.`val` > newInput.`val`) {
                var temp = newHead
                newHead = newInput
                newHead!!.next = temp
            } else {
                var cur = newHead
                while (cur!!.next != null) {
                    if (cur.next!!.`val`>newInput.`val`) {
                        var temp = cur.next
                        cur.next = newInput
                        newInput.next = temp
                        break
                    }
                    cur = cur!!.next
                }
                if (cur.next == null) {
                    cur.next = newInput
                    newInput.next = null
                }
            }
            newCur = next
        }
        return newHead
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var v4 = ListNode(4)
            var v2 = ListNode(2)
            var v1 = ListNode(1)
            var v3 = ListNode(3)
            v4.next = v2
            v2.next = v1
            v1.next = v3
            S147().insertionSortList(v4)
        }
    }
}