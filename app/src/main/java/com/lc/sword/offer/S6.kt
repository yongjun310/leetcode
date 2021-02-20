package com.lc.sword.offer

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList

/*
剑指 Offer 06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



示例 1：

输入：head = [1,3,2]
输出：[2,3,1]


限制：

0 <= 链表长度 <= 10000

通过次数154,683提交次数205,439
 */

class S6 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reversePrint(head: ListNode?): IntArray {
        var pre = head
        if (head == null) {
            return intArrayOf()
        }
        var cur = head.next
        pre!!.next = null
        var count = 1
        var tmp = head
        while (cur != null) {
            tmp = cur.next
            cur.next = pre
            pre = cur
            cur = tmp
            count++
        }
        cur = pre
        var retArray = IntArray(count)
        count = 0
        while (cur != null) {
            retArray[count++] = cur.`val`
            cur = cur.next
        }
        return retArray
    }
    fun reversePrint1(head: ListNode?): IntArray {
        var cur = head
        if (head == null) {
            return intArrayOf()
        }
        var stack = Stack<Int>()
        var count = 0
        while (cur != null) {
            stack.push(cur.`val`)
            cur = cur.next
            count++
        }
        var retArray = IntArray(count)
        count = 0
        while (stack.isNotEmpty()) {
            retArray[count++] = stack.pop()
        }
        return retArray
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var a1 = null
            print(S6().reversePrint1(a1))
        }
    }
}