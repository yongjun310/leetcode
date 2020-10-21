package com.lc.source.s400

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.min

/*
447. Number of Boomerangs
Easy

430

728

Add to List

Share
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:

Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]


Accepted
70,338
Submissions
135,043
 */

class S447{
    fun numberOfBoomerangs(points: Array<IntArray>): Int {
        var ret = 0
        for(i in points.indices) {
            var map = HashMap<Double, Int>()
            for(j in points.indices) {
                if(i != j) {
                    var dis = Math.pow(points[i][0]-points[j][0].toDouble(), 2.toDouble()) +
                            Math.pow(points[i][1]-points[j][1].toDouble(), 2.toDouble())
                    map.put(dis, if(map.get(dis)==null) 1 else map.get(dis)!! + 1)
                }
            }
            var iterator = map.iterator()
            while(iterator.hasNext()) {
                var next = iterator.next()
                if(next.value>=2) {
                    ret += next.value * (next.value-1)
                }
            }
        }
        return ret
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}