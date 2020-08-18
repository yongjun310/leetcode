package com.lc.source.s1;

/*
83. Remove Duplicates from Sorted List
Easy

1657

117

Add to List

Share
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
 */
public class S83 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode b = new S83().deleteDuplicates(head);
        System.out.print(" " + b.val);
        while (b.next != null) {
            System.out.print(" " + b.next.val);
            b = b.next;
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode lastNode, curNode;
        lastNode = head;
        if (head == null) {
            return head;
        }
        curNode = head.next;
        while (curNode != null) {
            if (curNode.val == lastNode.val) {
                lastNode.next = curNode.next;
                curNode = curNode.next;
            } else {
                lastNode = curNode;
                curNode = curNode.next;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
