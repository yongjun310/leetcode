package com.lc.source.s100

import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue

/*
134. Gas Station
Medium

2741

424

Add to List

Share
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique



Example 1:

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.


Constraints:

gas.length == n
cost.length == n
1 <= n <= 104
0 <= gas[i], cost[i] <= 104
Accepted
272,156
Submissions
659,807
 */

class S134 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        for (i in gas.indices) {
            gas[i] = gas[i] - cost[i]
        }
        var debt = 0
        var remain = 0
        var start = 0
        for (i in gas.indices) {
            remain += gas[i]
            if (remain<0) {
                debt += remain
                remain = 0
                start = i+1
            }
        }
        return if (debt+remain>=0) start else -1
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S134().canCompleteCircuit(intArrayOf(2,3,4), intArrayOf(3,4,3)))
        }
    }
}