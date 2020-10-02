import com.lc.source.s1100.S1160
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
1290. Convert Binary Number in a Linked List to Integer
Easy

630

48

Add to List

Share
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.



Example 1:


Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:

Input: head = [0]
Output: 0
Example 3:

Input: head = [1]
Output: 1
Example 4:

Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880
Example 5:

Input: head = [0,0]
Output: 0


Constraints:

The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.
Accepted
92,677
Submissions
114,754
*/
class S1290{
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun getDecimalValue(head: ListNode?): Int {
        var ri = 0
        var node = head
        while(node != null) {
            ri *= 2
            ri += node.`val`
            node = node.next
        }
        return ri
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
