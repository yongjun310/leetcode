package com.lc.source.s600;

/*
687. Longest Univalue Path
Easy

1793

482

Add to List

Share
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.
Example 1:
Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output: 2
Example 2:
Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output: 2



Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class S687 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(5);
        TreeNode h = new TreeNode(4);
        TreeNode i = new TreeNode(4);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        d.left = h;
        e.right = i;
        c.right = f;
        f.left = g;
        System.out.println(new S687().longestUnivaluePath(a));
    }

    public int longestUnivaluePath(TreeNode root) {
        findLongPath(root);
        return maxLen;
    }

    int maxLen = 0;
    int findLongPath(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }
        int pl = 0, pr = 0;
        int leftLongPath = findLongPath(treeNode.left);
        int rightLongPath = findLongPath(treeNode.right);
        if(treeNode.left != null && treeNode.left.val == treeNode.val) {
            pl = leftLongPath + 1;
        }
        if(treeNode.right != null && treeNode.right.val == treeNode.val) {
            pr = rightLongPath + 1;
        }
        maxLen = Math.max(maxLen, pl + pr);
        return Math.max(pl, pr);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
