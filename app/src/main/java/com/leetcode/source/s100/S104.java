package com.leetcode.source.s100;

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
        stack.push(root);
        TreeNode tmp;
        int maxDepth = 0;
        int curDepth = 1;
        while(true) {
            tmp = stack.get(stack.size()-1);
            if(tmp == null) {
                break;
            }
            if(tmp.left != null && tmp.left != root) {
                stack.push(tmp.left);
                tmp.left = root;
                curDepth++;
            } else if(tmp.right != null && tmp.right != root) {
                stack.push(tmp.right);
                tmp.right = root;
                curDepth++;
            } else {
                if(curDepth > maxDepth && tmp.left != root && tmp.right != root) {
                    maxDepth = curDepth;
                }
                curDepth--;
                stack.pop();
                if(stack.size() == 0) {
                    break;
                }
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
