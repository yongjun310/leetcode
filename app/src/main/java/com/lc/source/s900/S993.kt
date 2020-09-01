package com.lc.source.s900

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*



Constraints:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
Accepted
115,382
Submissions
221,826
 */

class S993 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var xdep = 0
    var ydep = 0
    var samep = false
    fun search(root: TreeNode?, x: Int, y: Int, d: Int) {
        if(root == null) {
            return
        }
        var dep = d+1
        var findx = false
        var findy = false
        if(root.left != null) {
            if(x == root.left?.`val`) {
                xdep = dep
                findx = true
            } else if(y == root.left?.`val`) {
                ydep = dep
                findy = true
            }
        }
        if(root.right != null) {
            if(y == root.right?.`val`) {
                ydep = dep
                findy = true
            } else if(x == root.right?.`val`) {
                xdep = dep
                findx = true
            }
        }
        if(findx && findy) {
            samep = true
        }
        if(xdep != 0 && ydep != 0) {
            return
        }
        search(root.left, x, y, dep)
        search(root.right, x, y, dep)
    }

    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        search(root, x, y, 0)
        return xdep == ydep && !samep
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var a = TreeNode(1)
            var b = TreeNode(2)
            var c = TreeNode(3)
            var d = TreeNode(4)
            var e = TreeNode(5)
            a.left = b
            a.right = c
            b.right = d
            c.right = e
            println(S993().isCousins(a, 5, 4))
        }
    }

}