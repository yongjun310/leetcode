package com.leetcode.source.s100;


public class S124 {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        calSum(root);
        return max;
    }

    public static int calSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = calSum(root.left);
        int right = calSum(root.right);
        if(left < 0) {
            left = 0;
        }
        if(right < 0) {
            right = 0;
        }
        max = Math.max(max,  left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        /**[-10,9,20,null,null,15,7]*/
        TreeNode a = new TreeNode(-10);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        int minDepth = maxPathSum(a);

        System.out.print(" " + minDepth);
    }
}
