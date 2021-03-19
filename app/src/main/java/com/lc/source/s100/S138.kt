package com.lc.source.s100

import java.util.*

/*
138. Copy List with Random Pointer
Medium

4866

802

Add to List

Share
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.



Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
Example 4:

Input: head = []
Output: []
Explanation: The given linked list is empty (null pointer), so return null.


Constraints:

0 <= n <= 1000
-10000 <= Node.val <= 10000
Node.random is null or is pointing to some node in the linked list.
Accepted
544,454
Submissions
1,323,258
 */

class S138 {
    class Node(var `val`: Node?) {
        var next: Node? = null
        var random: Node? = null
    }

    fun copyRandomList(node: Node?): Node? {
        var count = 0
        var cur = node
        while (cur != null) {
            var n2 = Node(cur.`val`)
            n2.next = cur.next
            cur.next = n2
            cur = n2.next
        }
        cur = node
        while (cur != null) {
            cur.next!!.random = cur.random?.next
            cur = cur.next?.next
        }
        cur = node
        var newHead = if (cur!=null) cur.next else null
        while (cur?.next != null) {
            var l2 = cur.next
            cur.next = cur.next?.next
            l2?.next = cur.next?.next
            cur = cur.next

        }
        return newHead
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}