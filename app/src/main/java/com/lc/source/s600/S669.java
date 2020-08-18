package com.lc.source.s600;

/*
669. Trim a Binary Search Tree
Easy

1889

180

Add to List

Share
Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L).
You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input:
    1
   / \
  0   2

  L = 1
  R = 2

Output:
    1
      \
       2
Example 2:
Input:
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output:
      3
     /
   2
  /
 1
 */
public class S669 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(0);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.right = d;
        d.left = e;
        TreeNode minDepth = new S669().trimBST(a, 1, 3);
        printTree(minDepth);

    }

    public static void printTree(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) {
            return root;
        }
        if(root.val < L) {
            return trimBST(root.right, L, R);
        } else if(root.val > R) {
            return trimBST(root.left, L, R);
        } else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }
        return root;
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
