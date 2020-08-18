package com.lc.source.s1;

public class S21 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, head1, head2, cur;
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        head1 = l1;
        head2 = l2;
        if(l1.val<l2.val) {
            head = l1;
            head1 = l1.next;
        } else {
            head = l2;
            head2 = l2.next;
        }
        cur = head;
        while(head1 != null && head2 != null) {
            if(head1.val<head2.val) {
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            } else {
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }
        if(head1 != null) {
            cur.next = head1;
        }

        if(head2 != null) {
            cur.next = head2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        head.next = n2;
        n2.next = n3;

        n4.next = n5;
        n5.next = n6;

        ListNode b = mergeTwoLists(head, n4);
        while(b.next != null) {
            System.out.print(" " + b.val);
            b = b.next;
        }
    }
}
