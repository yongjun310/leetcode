package com.leetcode.source.s100;

import java.util.Stack;

public class S110 {
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

    public static boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        TreeNode tmp;
        while(true) {
            if(stack.size() == 0) {
                return true;
            }
            tmp = stack.get(stack.size()-1);
            if(tmp.left != null && tmp.left != root || tmp.right != null && tmp.right != root) {
                if(Math.abs(maxDepth(tmp.left) - maxDepth(tmp.right)) > 1) {
                    return false;
                }
                if(tmp.left != null && tmp.left != root) {
                    stack.push(tmp.left);
                    tmp.left = root;
                }
                if(tmp.right != null && tmp.right != root) {
                    stack.push(tmp.right);
                    tmp.right = root;
                }
            } else {
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a21 = new TreeNode(2);
        TreeNode a22 = new TreeNode(2);
        TreeNode a31 = new TreeNode(3);
        TreeNode a32 = new TreeNode(3);
        TreeNode a41 = new TreeNode(4);
        TreeNode a42 = new TreeNode(4);
        a1.left = a21;
        a1.right = a22;
        a21.left = a31;
        a22.right = a32;
        a31.left = a41;
        a32.right = a42;
        boolean isB = isBalanced(a1);

        System.out.print(" " + isB);
    }
}
