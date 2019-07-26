package com.leetcode.source.s600;

/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 *
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs
 * that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 *
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * Output: "1(2(4))(3)"
 *
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * Output: "1(2()(4))(3)"
 *
 * Explanation: Almost the same as the first example,
 * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */
public class S606 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static String tree2str(TreeNode t) {
        StringBuilder ret = new StringBuilder();
        transferNode(t, ret);
        return ret.toString();
    }

    private static StringBuilder transferNode(TreeNode t, StringBuilder ret) {
        if(t != null) {
            ret.append(t.val);
        } else {
            return ret;
        }
        if(t.left == null) {
            if (t.right != null) {
                ret.append("()");
            }
        } else {
            ret.append("(");
            ret = transferNode(t.left, ret);
            ret.append(")");
        }
        if(t.right != null) {
            ret.append("(");
            ret = transferNode(t.right, ret);
            ret.append(")");
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        r.left = r2;
        r.right = r3;
        r2.right = r4;
        String b = tree2str(r);
        System.out.print(" " + b);
    }
}
