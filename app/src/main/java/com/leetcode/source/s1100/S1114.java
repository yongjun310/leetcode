package com.leetcode.source.s1100;

/**
 * Suppose we have a class:
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * The same instance of Foo will be passed to three different threads.
 * Thread A will call first(), thread B will call second(), and thread C will call third().
 * Design a mechanism and modify the program to ensure that second() is executed after first(),
 * and third() is executed after second().
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously.
 * The input [1,2,3] means thread A calls first(), thread B calls second(),
 * and thread C calls third(). "firstsecondthird" is the correct output.
 * Example 2:
 *
 * Input: [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(),
 * and thread C calls second(). "firstsecondthird" is the correct output.
 */
public class S1114 {

    private int index = 0;
    private Byte b1;

    public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        index++;
        synchronized (b1) {
            notify();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (b1) {
            while (index != 1) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            index++;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (b1) {
            while (index != 2) {
                wait();
            }
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {

    }
}
