package com.lc.sword.offer

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap

/*
 */

class Microsoft_loop_3 {

    fun findElement(arr: Array<Int>, k: Int): Int {
        var bigger = 0
        for (i in 0 until k) {
            var bigger = arr[0]
            for (j in 1..arr.size-1-i) {
                if (arr[j]>bigger) {
                    var tmp = bigger
                    bigger = arr[j]
                    arr[j] = tmp
                }
            }
        }
        return bigger
    }

    fun findElement2(arr: Array<Int>, k: Int): Int {
        return helper(arr, 0, arr.size-1, k)
    }

    private fun helper(arr: Array<Int>, i: Int, i1: Int, k: Int): Int {
        var tag = arr[0]
        var start = 1
        var end = arr.size-1
        while (start<end) {
            while (start++<end) {
                if (arr[start]>tag) {
                    break
                }
            }
            while (end-->start) {
                if (arr[end]<tag) {
                    break
                }
            }
            var tmp = arr[start]
            arr[start] = arr[end]
            arr[end] = tmp
        }
        var tmp = arr[0]
        arr[0] = arr[start]
        arr[start] = tmp
        if (start == k) {
            return arr[start]
        } else if(start > k) {
            return helper(arr, 0, start, k)
        } else {
            return helper(arr, start+1, end, k-start)
        }
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}