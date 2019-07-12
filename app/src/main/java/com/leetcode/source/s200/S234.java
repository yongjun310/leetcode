package com.leetcode.source.s200;

public class S234 {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static boolean isPalindrome(ListNode head) {
        ListNode tmp = head;
        int count = 0;
        while(tmp != null) {
            tmp = tmp.next;
            count++;
        }
        if(count <= 1) {
            return true;
        }
        tmp = head;
        ListNode pre,cur,next= null;
        int cmpc = count/2;
        count = (count+1)/2;
        while(count-->0) {
            tmp = tmp.next;
        }
        pre = tmp;
        cur = tmp.next;
        if(cur != null) {
            next = cur.next;
        }
        ListNode nn = null;
        while(next != null) {
            nn = next.next;
            next.next = cur;
            cur.next = pre;
            if(nn != null) {
                pre = cur;
                cur = next;
                next = nn;
            } else {
                break;
            }
        }
        if(cmpc == 1) {
            next = pre;
        }
        if(cmpc == 2) {
            cur.next = pre;
            next = cur;
        }
        tmp = head;
        while(cmpc-->0 && next != null && tmp != null) {
            if(tmp.val != next.val) {
                return false;
            }
            tmp = tmp.next;
            next = next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        head.next = n2;

        boolean b = isPalindrome(head);
        System.out.print(" " + b);
    }
}
