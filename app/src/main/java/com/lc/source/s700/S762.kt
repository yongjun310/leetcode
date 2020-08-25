package com.lc.source.s700

/*
762. Prime Number of Set Bits in Binary Representation
Easy

257

339

Add to List

Share
Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.

(Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

Example 1:

Input: L = 6, R = 10
Output: 4
Explanation:
6 -> 110 (2 set bits, 2 is prime)
7 -> 111 (3 set bits, 3 is prime)
9 -> 1001 (2 set bits , 2 is prime)
10->1010 (2 set bits , 2 is prime)
Example 2:

Input: L = 10, R = 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
Note:

L, R will be integers L <= R in the range [1, 10^6].
R - L will be at most 10000.

 */

class S762 {
    fun countBits(s: Int): Int {
        var l = s
        var c = 0
        while(l>0) {
            if (l and 1 == 1) {
                c++
            }
            l = l shr 1
        }
        return c
    }

    fun isPrime(s: Int): Boolean{
        if(s == 1) {
            return false
        }
        if(s == 2) {
            return true
        }
        var t = Math.sqrt(s.toDouble()).toInt()
        for(i in 2..t) {
            if(s%i == 0) {
                return false
            }
        }
        return true
    }

    fun countPrimeSetBits(L: Int, R: Int): Int {
        var s = L
        var c = 0
        while(s<=R) {
            var b = countBits(s)
            if(isPrime(b)) {
                c++
            }
            s++
        }
        return c
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S762().countPrimeSetBits(10, 151231))
        }
    }

}