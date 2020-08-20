package com.lc.source.s100

import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.math.min

/*
155. Min Stack
Easy

3647

348

Add to List

Share
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.


Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2


Constraints:

Methods pop, top and getMin operations will always be called on non-empty stacks.
 */

class S155 {

    /** initialize your data structure here. */
    var stack = Stack<Int>()
    var minStack = Stack<Int>()

    fun push(x: Int) {
        stack.push(x)
        if(minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x)
        }
    }

    fun pop() {
        var m = stack.pop()
        if(m == minStack.peek()) {
            minStack.pop()
        }
    }

    fun top(): Int? {
        return stack.peek()
    }

    fun getMin(): Int? {
        return minStack.peek()
    }


    /**
     * Your MinStack object will be instantiated and called as such:
     * var obj = MinStack()
     * obj.push(x)
     * obj.pop()
     * var param_3 = obj.top()
     * var param_4 = obj.getMin()
     */

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}