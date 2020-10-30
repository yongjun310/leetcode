package com.lc.source.s500

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.absoluteValue

/*
589. N-ary Tree Preorder Traversal
Easy

744

63

Add to List

Share
Given an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).



Follow up:

Recursive solution is trivial, could you do it iteratively?



Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]


Constraints:

The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 10^4]
Accepted
122,212
Submissions
168,063
 */

class S589{
    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    fun preorder(root: Node, list:ArrayList<Int>) {
        list.add(root.`val`)
        for(e in root.children) {
            if(e != null) {
                preorder(e, list)
            }
        }
    }

    fun preorder(root: Node?): List<Int> {
        var list = ArrayList<Int>()
        if(root == null) {
            return list
        }
        preorder(root, list)
        return list
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}