package com.lc.sword.offer

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap

/*

 */

class Microsoft_loop_4 {
    class ListNode(var `val`: Int) {
         var next: ListNode? = null
    }

    // "一万九千七百三十一
    fun translateNumber(str: String): Int {
        var ret = 0
        var cur = 0
        var hasGap = false
        for (i in str.indices) {
            when(str[i]) {
                '零' -> hasGap = true
                '一' -> cur += 1
                '二' -> cur += 2
                '三' -> cur += 3
                '四' -> cur += 4
                '五' -> cur += 5
                '六' -> cur += 6
                '七' -> cur += 7
                '八' -> cur += 8
                '九' -> cur += 9

                '亿' -> {
                    ret += cur*100000000
                    cur = 0
                }
                '万' ->
                    if (hasGap){
                        ret += cur*10000
                        hasGap = false
                        cur = 0
                    } else {
                        cur *= 10000
                    }
                '千' -> {
                    if (hasGap) {
                        ret += cur * 1000
                        hasGap = false
                        cur = 0
                    } else {
                        cur *= 1000
                    }
                }
                '百' -> {
                    if (hasGap) {
                        ret += cur*100
                        hasGap = false
                        cur = 0
                    } else {
                        cur *= 100
                    }
                }
                '十' -> {
                    if (hasGap) {
                        ret += cur*10
                        hasGap = false
                        cur = 0
                    } else {
                        cur *= 10
                    }
                }
            }
        }
        ret += cur
        return ret
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println(Microsoft_loop_4().translateNumber("三亿零五千九百")) //300005900
            println(Microsoft_loop_4().translateNumber("三亿五千零九万九千七百三十一"))
            println(Microsoft_loop_4().translateNumber("三亿零五千零九"))
            println(Microsoft_loop_4().translateNumber("零"))
            println(Microsoft_loop_4().translateNumber("零亿五千九百万"))
            println(Microsoft_loop_4().translateNumber("零亿五千九百"))
        }
    }
}