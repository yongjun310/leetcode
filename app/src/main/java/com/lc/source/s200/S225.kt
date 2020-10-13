package com.lc.source.s200

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.HashMap
import kotlin.math.min

/*
225. Implement Stack using Queues
Easy

809

606

Add to List

Share
Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal queue (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue), as long as you use only a queue's standard operations.
Follow-up: Can you implement the stack such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.



Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False


Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, top, and empty.
All the calls to pop and top are valid.
Accepted
194,239
Submissions
421,569
 */

class S225 {
    /** Initialize your data structure here. */
    var queue = ConcurrentLinkedQueue<Int>()
    var queue1 = ConcurrentLinkedQueue<Int>()

    /** Push element x onto stack. */
    fun push(x: Int) {
        queue.add(x)
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        while(queue.size>1) {
            queue1.add(queue.poll())
        }
        var top = queue.poll()
        var temp = queue1
        queue1 = queue
        queue = temp
        return top
    }

    /** Get the top element. */
    fun top(): Int {
        while(queue.size>1) {
            queue1.add(queue.poll())
        }
        var top = queue.poll()
        var temp = queue1
        queue1 = queue
        queue = temp
        queue.add(top)
        return top
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return queue.isEmpty()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var s = S225()
            s.push(1)
            s.push(2)
            s.pop()
        }
    }
}