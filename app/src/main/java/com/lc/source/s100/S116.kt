package com.lc.source.s100

import java.util.*
import java.util.concurrent.LinkedBlockingQueue

/*
116. Populating Next Right Pointers in Each Node
Medium

3034

159

Add to List

Share
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.



Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.


Example 1:



Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.


Constraints:

The number of nodes in the given tree is less than 4096.
-1000 <= node.val <= 1000
Accepted
456,492
Submissions
934,459
 */

class S116 {
    class Node (
        var `val`: Int = 0,
    ) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun connect(root: Node?): Node? {
        if (root == null) {
            return root
        }
        var queue = LinkedBlockingQueue<Node>()
        queue.put(root)
        var c = 1
        while (queue.isNotEmpty()) {
            var cur = queue.poll()
            var pre: Node? = null
            var curc = c
            while (c-->0) {
                cur.next = pre
                pre = cur
                cur.right?.let { queue.put(it) }
                cur.left?.let { queue.put(it) }
                if (c>0) {
                    cur = queue.poll()
                }
            }
            c = curc shl 1
        }
        return root
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var l1 = Node(1)
            var l2 = Node(2)
            var l3 = Node(3)
            var l4 = Node(4)
            var l5 = Node(5)
            var l6 = Node(6)
            var l7 = Node(7)
            l1.left = l2
            l1.right = l3
            l2.left = l4
            l2.right = l5
            l3.left = l6
            l3.right = l7
            var s = S116().connect(l1)
            print(s)
        }
    }
}