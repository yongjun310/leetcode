package com.lc.source.s500

import kotlin.collections.ArrayList

/*
559. Maximum Depth of N-ary Tree
Easy

1036

50

Add to List

Share
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).



Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: 3
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: 5


Constraints:

The depth of the n-ary tree is less than or equal to 1000.
The total number of nodes is between [0, 10^4].
Accepted
131,329
Submissions
190,196
 */

class S559{
    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    fun deep(root: Node?): Int {
        if(root == null) {
            return 0
        }
        var max = 0
        for(e in root.children) {
            var d = deep(e)
            if(d>max) {
                max = d
            }
        }
        return max + 1
    }

    fun maxDepth(root: Node?): Int {
        return deep(root)
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}