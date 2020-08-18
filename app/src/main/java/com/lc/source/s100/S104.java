package com.lc.source.s100;

import java.util.Stack;

public class S104 {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> subStack = new Stack<>();
        stack.push(root);
        TreeNode tmp;
        int maxDepth = 0;
        while(true) {
            if(stack.size() == 0) {
                break;
            }
            tmp = stack.pop();
            maxDepth++;
            while(true) {
                if(tmp.left != null) {
                    subStack.push(tmp.left);
                }
                if(tmp.right != null) {
                    subStack.push(tmp.right);
                }
                if(stack.size() > 0) {
                    tmp = stack.pop();
                } else {
                    break;
                }
            }
            while(subStack.size()>0) {
                stack.push(subStack.pop());
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        int minDepth = maxDepth(a);

        System.out.print(" " + minDepth);
    }
}
