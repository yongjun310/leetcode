package com.lc.source.s100

import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.ArrayList

/*
109. Convert Sorted List to Binary Search Tree
Medium

2656

93

Add to List

Share
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Example 1:


Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [0]
Output: [0]
Example 4:

Input: head = [1,3]
Output: [3,1]


Constraints:

The number of nodes in head is in the range [0, 2 * 104].
-10^5 <= Node.val <= 10^5
Accepted
279,960
Submissions
559,340
 */

class S109 {
    class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }

    class ListNode(var `val`: Int) {
         var next: ListNode? = null
    }

    fun sortedListToBST(head: ListNode?): TreeNode? {
        var cur = head
        var list = ArrayList<TreeNode>()
        while (cur != null) {
            list.add(TreeNode(cur.`val`))
            cur = cur.next
        }
        return helper(list, 0, list.size-1)
    }

    fun helper(list: ArrayList<TreeNode>, s:Int, e:Int): TreeNode? {
        if (s>e) {
            return null
        }
        if (s==e) {
            return list[s]
        }
        var ri = s + (e-s)/2
        list[ri].left = helper(list, s, ri-1)
        list[ri].right = helper(list, ri+1, e)
        return list[ri]
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var l1 = ListNode(-10)
            var l2 = ListNode(-3)
            var l3 = ListNode(0)
            var l4 = ListNode(5)
            var l5 = ListNode(9)
            l1.next = l2
            l2.next = l3
            l3.next = l4
            l4.next = l5
            var s = S109().sortedListToBST(l1)
            print(s)
        }
    }
}